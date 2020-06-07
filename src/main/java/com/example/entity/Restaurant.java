package com.example.entity;

public class Restaurant {
	private Long id;
	private String name;
	private String cuisine;

	public Restaurant() {
		super();
	}

	public Restaurant(Long id, String name, String cuisine) {
		super();
		this.id = id;
		this.name = name;
		this.cuisine = cuisine;
	}

	public Restaurant(String name, String cuisine) {
		super();
		this.name = name;
		this.cuisine = cuisine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	@Override
	public String toString() {
		return String.format("Restaurant [id=%s, name=%s, cuisine=%s]", id, name, cuisine);
	}

}
