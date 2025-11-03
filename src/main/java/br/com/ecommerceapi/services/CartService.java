package br.com.ecommerceapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.models.Cart;
import br.com.ecommerceapi.repositories.CartRepository;

@Service
public class CartService {

	
	
	@Autowired
	private CartRepository cartRepository;
	

	public Cart getCart(Integer id) {
		
		Optional<Cart> cart = cartRepository.findById(id);
		
		if(cart != null) {
			return cart.get();
			
		}else {
			return null;
		}
	}
	
	
	
}
