package com.cart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name = "cart")
public class Cart implements Serializable {

	@Override
	public String toString() {
		return "Cart [Id=" + id + ", Product_CartId=" + product_Id + ", price=" + price + ", description="
				+ description + ", name=" + name + ", userId=" + userId + "]";
	}

	@Id
	@Column(name = "cartId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int product_Id;
	
	

	public int getProduct_CartId() {
		return product_Id;
	}

	public void setProduct_CartId(int product_Id) {
		this.product_Id = product_Id;
	}

	private double price;

	private String description;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}


	private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
	private User userId;
	
    
    private int quantity=1;



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private double unitPrice;



	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
