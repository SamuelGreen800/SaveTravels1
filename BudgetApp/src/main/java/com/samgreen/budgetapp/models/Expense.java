package com.samgreen.budgetapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="expenses")

public class Expense {
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min = 1, max = 200, message = "Name required")
	private String name;
	
	@NotNull
	@Size(min=1, max=200, message="Wendor required")
	private String vendor;
	
	@NotNull(message="Amount must not be blank!")
	@Min(value=0, message="Amount must be greater than zero")
	private Double amount;
	
	@NotNull
	@Size(min=1, max=500, message="Please give a short description")
	private String description;
	
	public Expense() {}
	
	public Expense(int id, String name, String vendor, Double amount, String description) {
		this.id = id;
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
