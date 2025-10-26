package br.com.ecommerceapi.services;

import java.util.ArrayList;
import java.util.List;

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
	
	
	

}
