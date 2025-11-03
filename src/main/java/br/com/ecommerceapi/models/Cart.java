package br.com.ecommerceapi.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_carts")
@Data
public class Cart {
	
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="created_at")
	private LocalDateTime createdAt= LocalDateTime.now();
	@Column(name="updated_at")
	private LocalDateTime updated_at;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	private List<ItemCart> itemsCart = new ArrayList<>();
	
	

}
