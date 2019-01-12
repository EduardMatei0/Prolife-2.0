package com.eduardmatei.prolife.service;

import java.util.List;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.AnimalDetail;
import com.eduardmatei.prolife.entity.Proprietar;

public interface ProlifeService {
	
	public List<Proprietar> getProprietari();
	
	public void saveProprietar(Proprietar proprietar);

	public Proprietar getProprietar(int id);

	public void deleteProprietar(int id);
	
	public List<Animal> getAnimals();
	
	public void saveAnimal(Animal animal);
	
	public void addAnimalToProprietar(Animal animal, int proprietarId);
	
	public AnimalDetail getAnimalDetail(int id);
	
	
	
}
