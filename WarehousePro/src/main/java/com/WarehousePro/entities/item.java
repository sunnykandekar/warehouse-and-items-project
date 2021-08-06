package com.WarehousePro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ITEM")
public class item
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
     private String name;
     private String price;
     private int quantity; 
     
     
     @ManyToOne     
     private warehouse warehouse;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public warehouse getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(warehouse warehouse) {
		this.warehouse = warehouse;
	}


	public item(int id, String name, String price, int quantity, com.WarehousePro.entities.warehouse warehouse) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.warehouse = warehouse;
	}


	public item() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ",]";
	}
     
}