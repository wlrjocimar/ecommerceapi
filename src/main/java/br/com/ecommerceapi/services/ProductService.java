package br.com.ecommerceapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.models.Product;
import br.com.ecommerceapi.repositories.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProducts(){
			
		try {
			List<Product> products = productRepository.findAll();
			
			return products;
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		
		
		
	}

	public Product newProduct(Product product) {
		
		try {
			
			product.setId(null);
			return productRepository.save(product);
			
		} catch (Exception e) {
			System.out.println("Error while savin product  " +  e.getCause().toString());
			throw e;
		}
	}

	public void removeProductById(Integer productId) {
		try {
			// first of all, we must  find a product by id 
			Product product = this.getProductById(productId);
			productRepository.delete(product);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	private Product getProductById(Integer productId) {
		
		try {
			
			Optional<Product> productOptional = productRepository.findById(productId);
			Product product = productOptional.get();
			return product;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	
	
	
	

}
