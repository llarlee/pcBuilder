package net.pcbuilder.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import net.pcbuilder.exception.ResourceNotFoundException;
import net.pcbuilder.model.CPUnit;
import net.pcbuilder.model.Cart;
import net.pcbuilder.model.Motherboard;
import net.pcbuilder.model.RAM;
import net.pcbuilder.repository.CPURepository;
import net.pcbuilder.repository.CartRepository;
import net.pcbuilder.repository.MOBORepository;
import net.pcbuilder.repository.RAMRepository;

@RestController
@RequestMapping("/api/v1")
public class PCBuilderController {
	
	@Autowired
	@Qualifier("moboRepository")
	private MOBORepository moboRepository;
	
	@Autowired
	private CPURepository cpuRepository;
	
	@Autowired
	private RAMRepository ramRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@GetMapping("/mobo")
	public ResponseEntity<List<Motherboard>> getAllMotherboards(@RequestParam(required = false) String name) {
		
		ResponseEntity entity = null;
		List<Motherboard> mobos = new ArrayList<Motherboard>();	
		
		try {					
			moboRepository.findAll().forEach(mobos::add);
			
			if (mobos.isEmpty()) {
				entity = new ResponseEntity<List<Motherboard>>(HttpStatus.NO_CONTENT);
			}
			else {
				entity = new ResponseEntity<List<Motherboard>>(mobos, HttpStatus.OK);
			}
		} catch(Exception ex) {
			entity = new ResponseEntity<List<Motherboard>>(mobos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@GetMapping("/mobo/{id}")
	public ResponseEntity<Motherboard> getMotherboardById(@PathVariable("id") long id) {
		Optional<Motherboard> moboData = moboRepository.findById(id);

		if (moboData.isPresent()) {
			return new ResponseEntity<>(moboData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ram")
	public ResponseEntity<List<RAM>> getAllRAM(@RequestParam(required = false) String name) {
		try {
			List<RAM> rams = new ArrayList<RAM>();

			if (name == null)
				ramRepository.findAll().forEach(rams::add);
			else
				//ramRepository.findByNameContaining(name).forEach(rams::add);

			if (rams.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(rams, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ram/{id}")
	public ResponseEntity<RAM> getRAMById(@PathVariable("id") long id) {
		Optional<RAM> ramData = ramRepository.findById(id);

		if (ramData.isPresent()) {
			return new ResponseEntity<>(ramData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/cpu")
	public ResponseEntity<List<CPUnit>> getAllCPU(@RequestParam(required = false) String name) {
		try {
			List<CPUnit> cpus = new ArrayList<CPUnit>();

			if (name == null)
				cpuRepository.findAll().forEach(cpus::add);
			else
				//cpuRepository.findByNameContaining(name).forEach(cpus::add);

			if (cpus.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cpus, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cpu/{id}")
	public ResponseEntity<CPUnit> getCPUById(@PathVariable("id") long id) {
		Optional<CPUnit> cpuData = cpuRepository.findById(id);

		if (cpuData.isPresent()) {
			return new ResponseEntity<>(cpuData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> getAllCart(@RequestParam(required = false) String name) {
		try {
			List<Cart> carts = new ArrayList<Cart>();

			if (name == null)
				cartRepository.findAll().forEach(carts::add);
			else
				//cartRepository.findByNameContaining(name).forEach(carts::add);

			if (carts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(carts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("id") long id) {
		Optional<Cart> cartData = cartRepository.findById(id);

		if (cartData.isPresent()) {
			return new ResponseEntity<>(cartData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
