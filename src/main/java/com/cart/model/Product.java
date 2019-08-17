package com.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="item")
public class Product {
	
	
	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	
	@Column(name = "description")
	private String productDescription;	 
	
	
	@Column(name = "name")
	private String productName;
		
		
	@Column(name = "price")
	private double productPrice;
	
	@Transient
	private MultipartFile productImage;

	// Getters and Setter


	public int getProductId() {
		return productId;
	}

	public String getProductDescription() {
		return productDescription;
	}


	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	// Constructors
	public Product(int productId, String productCategory, String productDescription, String productManufacturer,
			String productName,double originalPrice, double productPrice, String unitStock) {
		super();
		this.productId = productId;
		this.productDescription = productDescription;
		this.productName = productName;
		this.productPrice = productPrice;

	}

	public Product() {

	}

	
}
