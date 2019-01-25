package com.eduardmatei.prolife.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardmatei.prolife.dao.AnimalDAO;
import com.eduardmatei.prolife.entity.Animal;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	private final AnimalDAO animalDao;
	
	
	@Autowired
	public AnimalServiceImpl(AnimalDAO animalDao) {
		this.animalDao = animalDao;
	}

	@Override
	@Transactional
	public List<Animal> getAnimals() {		
		return animalDao.getAnimals();
	}

	@Override
	@Transactional
	public void saveAnimal(Animal animal, int proprietarId) {
		animalDao.saveAnimal(animal, proprietarId);
	}

	@Override
	@Transactional
	public Animal getAnimal(int id) {		
		return animalDao.getAnimal(id);
	}

	@Override
	@Transactional
	public void deleteAnimal(int id) {
		animalDao.deleteAnimal(id);
	}

}
