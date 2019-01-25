package com.eduardmatei.prolife.dao;

import java.util.List;

import com.eduardmatei.prolife.entity.Animal;

public interface AnimalDAO {
	
	public List<Animal> getAnimals();
	
	public void saveAnimal(Animal animal, int proprietarId);
			
	public Animal getAnimal(int id);
			
	public void deleteAnimal(int id);
	
}
