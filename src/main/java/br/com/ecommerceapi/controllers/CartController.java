package br.com.ecommerceapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.models.Cart;
import br.com.ecommerceapi.services.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("carts")
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable Integer id){
		
		Cart cart = cartService.getCart(id);
		
		return ResponseEntity.ok().body(cart);
		
		
		
	}
	

}
