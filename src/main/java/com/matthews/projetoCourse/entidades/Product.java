package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	private String nameProduct;
	private String descriptionProduct;
	private Double priceProduct;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_ProductCategory",
	joinColumns = @JoinColumn(name = "idProduct"),
	inverseJoinColumns = @JoinColumn(name = "idCategory"))
	private Set<Category> categoryProduct = new HashSet<>();;
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> setOrderItem = new HashSet<>();
	
	
	public Product() {
	}

	public Product(Long idProduct, String nameProduct, String descriptionProduct, Double priceProduct, String imgUrl) {
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.imgUrl = imgUrl;
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

	public Set<Category> getCategoryProduct() {
		return categoryProduct;
	}
	
	public Set<OrderItem> getSetOrderItem() {
		return setOrderItem;
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
