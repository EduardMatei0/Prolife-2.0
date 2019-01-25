package com.eduardmatei.prolife.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="proprietar")
public class Proprietar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="telefon")
	private String telefon;
	
	@Column(name="data")
	private Date data;
	
	@OneToMany(mappedBy="proprietar",
				cascade= {CascadeType.DETACH, CascadeType.PERSIST,
						 CascadeType.REFRESH, CascadeType.MERGE})
	private List<Animal> animals;
	
	public Proprietar() {
		// TODO Auto-generated constructor stub
	}

	public Proprietar(String firstName, String lastName, String telefon, Date data) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telefon = telefon;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	
	public void add(Animal animal) {
		if (animals == null) {
			animals = new ArrayList<>();
		}
		
		animals.add(animal);
		animal.setProprietar(this);
	}
	
	

	@Override
	public String toString() {
		return "Proprietar [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", telefon=" + telefon
				+ ", data=" + data + "]";
	}
	
	
}
