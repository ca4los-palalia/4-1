package com.cplsys.ai.domain;

public class Product {
	private String name;
	private String descripcion;
	private String nameImage;
	
	/*
	public Product(String name, String descripcion, String nameImage){
		this.name = name;
		this.descripcion = descripcion;
		this.nameImage = nameImage;
	}
	*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNameImage() {
		return nameImage;
	}
	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}
}
