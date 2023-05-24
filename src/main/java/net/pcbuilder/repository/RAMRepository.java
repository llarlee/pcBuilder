package net.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pcbuilder.model.RAM;

@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {
	
}
