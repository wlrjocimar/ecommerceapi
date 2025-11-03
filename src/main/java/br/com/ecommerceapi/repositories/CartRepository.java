package br.com.ecommerceapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerceapi.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
