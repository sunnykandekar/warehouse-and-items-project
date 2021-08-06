package com.WarehousePro.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="WAREHOUSE")
public class warehouse
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
	
     private String name;
 
     private String address;

     
     @OneToMany(cascade=CascadeType.ALL, fetch= FetchType.LAZY)        //bCoz ONE USER HAVE MANAY CONTACTS   
     private List<item> item= new ArrayList<>();


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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<item> getItem() {
		return item;
	}


	public void setItem(List<item> item) {
		this.item = item;
	}


	public warehouse(int id, String name, String address, List<com.WarehousePro.entities.item> item) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.item = item;
	}


	public warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "warehouse [id=" + id + ", name=" + name + ", address=" + address + ", item=" + item + "]";
	}
     
     
     

}
