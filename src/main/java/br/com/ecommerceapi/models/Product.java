package br.com.ecommerceapi.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_products")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name="short_description")
	private String shortDescription;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private BigDecimal price;
	
	@ElementCollection
	@CollectionTable(name="tb_product_colors",
	joinColumns = @JoinColumn(name="product_id"))
	@Column(name="color")
	private List<String> colors;
	
	@ElementCollection
	@CollectionTable(name="tb_product_sizes",
	joinColumns = @JoinColumn(name="product_id"))
	@Column(name="size")
	private List<String> sizes;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="tb_product_images",
	joinColumns = @JoinColumn(name="product_id"))
	@MapKeyColumn(name="color_name")
	@Column(name="image_path")
	private Map<String,String> images;
	
	

}
