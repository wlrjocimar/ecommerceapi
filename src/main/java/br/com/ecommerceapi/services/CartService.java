package br.com.ecommerceapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.dtos.CartInputDTO;
import br.com.ecommerceapi.dtos.ItemCartInputDTO;
import br.com.ecommerceapi.models.Cart;
import br.com.ecommerceapi.models.ItemCart;
import br.com.ecommerceapi.models.Product;
import br.com.ecommerceapi.repositories.CartRepository;

@Service
public class CartService {

	
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@Autowired
	private ProductService productService;
	

	public Cart getCart(Integer id) {
		
		Optional<Cart> cart = cartRepository.findById(id);
		
		if(cart != null) {
			return cart.get();
			
		}else {
			return null;
		}
	}


	public Cart newCart(CartInputDTO cartDTO) {
		
		try {
			List<ItemCart> items = new ArrayList<>();
			
			Cart cart = new  Cart();
			
			for (ItemCartInputDTO itemCartDTO : cartDTO.getItemsCart()) {
				Product product = productService.getProductById(itemCartDTO.getProductId());
				
				ItemCart itemCart = new ItemCart(itemCartDTO,product,cart);
//				itemCart.setCart(cart);
//				itemCart.setProduct(product);
//				itemCart.setSelectedColor(itemCartDTO.getSelectedColor());
//				itemCart.setSelectedSize(itemCartDTO.getSelectedSize());
				items.add(itemCart);
				
				
			}
			
			cart.setItemsCart(items);
			
			
			
			
			Cart savedCart = cartRepository.save(cart);
			return savedCart;
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		
	}
	
	
	
}
