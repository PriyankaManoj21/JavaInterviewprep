package com.projectinterview;

import java.util.List;

public class Employee {

	
	public Employee(int id, String name, List cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}
	private int id;
	private String name;
	private List cities;
	
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

	public List getCities() {
		return cities;
	}

	public void setCities(List cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cities=" + cities + "]";
	}
	
	
}
