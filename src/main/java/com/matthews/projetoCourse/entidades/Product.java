package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idProduct;
	private String nameProduct;
	private String descriptionProduct;
	private Double priceProduct;
	private String imgUrl;
	
	private Category categoryProduct;
	private List<Order> listOrderProduct = new ArrayList<>();
	
	public Product() {
		super();
	}

	public Product(Long idProduct, String nameProduct, String descriptionProduct, Double priceProduct, String imgUrl,
			Category categoryProduct) {
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.imgUrl = imgUrl;
		this.categoryProduct = categoryProduct;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Category getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(Category categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public List<Order> getListOrderProduct() {
		return listOrderProduct;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(idProduct, other.idProduct);
	}
}
