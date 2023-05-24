package net.pcbuilder.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pcbuilder.model.Motherboard;

@Repository
@Qualifier("moboRepository")
public interface MOBORepository extends JpaRepository<Motherboard, Long> {
	
	
}
