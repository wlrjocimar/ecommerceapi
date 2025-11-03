package br.com.ecommerceapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_items")
public class ItemCart {
	
	@Id
	private Integer id;
	
	@OneToOne
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
	

}
