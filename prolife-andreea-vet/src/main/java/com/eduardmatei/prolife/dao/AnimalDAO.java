package com.eduardmatei.prolife.dao;

import java.util.List;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.AnimalDetail;
import com.eduardmatei.prolife.entity.Proprietar;

public interface AnimalDAO {
	
	public List<Animal> getAnimals();
	
	public void saveAnimal(Animal animal);
	
	public AnimalDetail getAnimalDetail(int id);
	
	public void addAnimalToProprietar(Animal animal, int proprietarId);
	
}
