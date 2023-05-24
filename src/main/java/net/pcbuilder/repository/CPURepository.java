package net.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pcbuilder.model.CPUnit;

@Repository
public interface CPURepository extends JpaRepository<CPUnit, Long> {

}
