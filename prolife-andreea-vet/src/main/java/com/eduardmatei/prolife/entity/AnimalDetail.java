package com.eduardmatei.prolife.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="animal_detail")
public class AnimalDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="anamneza")
	private String anamneza;
	
	@Column(name="tratament")
	private String tratament;
	
	@Column(name="observatii")
	private String observatii;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="animal_id")
	private Animal animal;
	
	public AnimalDetail() {
		// TODO Auto-generated constructor stub
	}

	public AnimalDetail(String anamneza, String tratament, String observatii) {
		this.anamneza = anamneza;
		this.tratament = tratament;
		this.observatii = observatii;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnamneza() {
		return anamneza;
	}

	public void setAnamneza(String anamneza) {
		this.anamneza = anamneza;
	}

	public String getTratament() {
		return tratament;
	}

	public void setTratament(String tratament) {
		this.tratament = tratament;
	}

	public String getObservatii() {
		return observatii;
	}

	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}
	
	

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "AnimalDetail [id=" + id + ", anamneza=" + anamneza + ", tratament=" + tratament + ", observatii="
				+ observatii + "]";
	}
	
	
}
