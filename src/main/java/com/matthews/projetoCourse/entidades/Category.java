package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idCategory;
	private String nameCategory;
	
	List<Product> listProcuctCategory;

	public Category() {
		super();
	}

	public Category(Long idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		this.listProcuctCategory = new ArrayList<>();
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public List<Product> getListProcuctCategory() {
		return listProcuctCategory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(idCategory, other.idCategory);
	}
}
