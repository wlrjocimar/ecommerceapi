package br.com.ecommerceapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerceapi.dtos.CartInputDTO;
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
		
		Cart cart = cartService.getCartById(id);
		
		return ResponseEntity.ok().body(cart);
		
		
		
	}
	
	
	@PostMapping
	public ResponseEntity<Cart> newCart(@RequestBody CartInputDTO cartDTO){
		
		Cart savedCart = cartService.newCart(cartDTO);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCart.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(savedCart);
		
	}
	
	
	
	

}
