package com.luminescent.digital.jijobedhybrisspringtestluminescent.model;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "category")
	@MapKey(name = "name")
	private Map<String, Subcategory> subcategory  = new HashMap<>();

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

	public Map<String, Subcategory> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Map<String, Subcategory> subcategory) {
		this.subcategory = subcategory;
	}
	

}
