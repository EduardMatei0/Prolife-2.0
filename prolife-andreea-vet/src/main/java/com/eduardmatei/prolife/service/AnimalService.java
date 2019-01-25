package com.eduardmatei.prolife.service;

import java.util.List;

import com.eduardmatei.prolife.entity.Animal;

public interface AnimalService {
	
	public List<Animal> getAnimals();
	
	public void saveAnimal(Animal animal, int proprietarId);
	
	public Animal getAnimal(int id);
	
	public void deleteAnimal(int id);
}
