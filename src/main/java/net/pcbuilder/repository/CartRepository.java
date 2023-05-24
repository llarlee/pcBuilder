package net.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pcbuilder.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
