package br.com.ecommerceapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ecommerceapi.dtos.ItemCartInputDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_items")
@Data
public class ItemCart {
	
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@OneToOne(cascade =CascadeType.REFRESH)
	@JoinColumn(name="product_id",referencedColumnName = "id")
	private Product product;
	
	@Column(name="quantity")
	private Integer quantity;
	@Column(name = "selected_size")
	private String selectedSize;
	@Column(name = "selected_color")
	private String selectedColor;
	
	@ManyToOne
	@JoinColumn(name = "cart_id",referencedColumnName = "id")
	private Cart cart;
	
	
	public ItemCart() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ItemCart(ItemCartInputDTO itemCartInputDTO, Product product, Cart cart) {
		this.quantity = itemCartInputDTO.getQuantity();
		this.selectedSize=itemCartInputDTO.getSelectedSize();
		this.selectedColor=itemCartInputDTO.getSelectedColor();
		this.product = product;
		this.cart=cart;
	}
	
	
	
	
	
	
	

}
