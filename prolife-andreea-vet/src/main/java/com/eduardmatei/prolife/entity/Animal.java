package com.eduardmatei.prolife.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nume")
	private String nume;
	
	@Column(name="specie")
	private String specie;
	
	@Column(name="rasa")
	private String rasa;
	
	@Column(name="greutate")
	private double greutate;
	
	@Column(name="data_nasterii")
	private Date dataNasterii;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
						  CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="proprietar_id")
	private Proprietar proprietar;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="animal_detail_id")
	private AnimalDetail animalDetail;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String nume, String specie, String rasa, double greutate, Date dataNasterii) {
		super();
		this.nume = nume;
		this.specie = specie;
		this.rasa = rasa;
		this.greutate = greutate;
		this.dataNasterii = dataNasterii;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getRasa() {
		return rasa;
	}

	public void setRasa(String rasa) {
		this.rasa = rasa;
	}

	public double getGreutate() {
		return greutate;
	}

	public void setGreutate(double greutate) {
		this.greutate = greutate;
	}

	public Date getDataNasterii() {
		return dataNasterii;
	}

	public void setDataNasterii(Date dataNasterii) {
		this.dataNasterii = dataNasterii;
	}
	
	

	public Proprietar getProprietar() {
		return proprietar;
	}

	public void setProprietar(Proprietar proprietar) {
		this.proprietar = proprietar;
	}
	
	
	public AnimalDetail getAnimalDetail() {
		return animalDetail;
	}

	public void setAnimalDetail(AnimalDetail animalDetail) {
		this.animalDetail = animalDetail;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nume=" + nume + ", specie=" + specie + ", rasa=" + rasa + ", greutate="
				+ greutate + ", dataNasterii=" + dataNasterii + "]";
	}
	
	
	
	
}
