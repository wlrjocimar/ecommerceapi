package br.com.ecommerceapi.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class CartInputDTO {
	
	private List<ItemCartInputDTO> itemsCart = new ArrayList<>();

}
