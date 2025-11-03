package br.com.ecommerceapi.dtos;

import lombok.Data;

@Data
public class ItemCartInputDTO {
	
	private Integer productId;
	private Integer quantity;
	private String selectedSize;
	private String selectedColor;

}
