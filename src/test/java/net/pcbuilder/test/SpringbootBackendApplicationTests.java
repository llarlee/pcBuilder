package net.pcbuilder.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.http.HttpClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.pcbuilder.model.Motherboard;

@SpringBootTest
@AutoConfigureMockMvc
class SpringbootBackendApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Motherboard mobo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getMotherboardsTest() throws Exception {
		
		Motherboard[] mobos = null;
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/mobo"))
		.andExpect(status().isOk());
		
	}
	
	@Test
	void getCPUTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cpu"))
		.andExpect(status().isOk());
		
	}
	
	@Test
	void getRAMTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ram"))
		.andExpect(status().isOk());
		
	}

}
