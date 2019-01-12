package com.eduardmatei.prolife.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardmatei.prolife.dao.AnimalDAO;
import com.eduardmatei.prolife.dao.ProprietarDAO;
import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.AnimalDetail;
import com.eduardmatei.prolife.entity.Proprietar;

@Service
public class ProlifeServiceImpl implements ProlifeService {

	@Autowired
	private ProprietarDAO proprietarDAO;
	
	@Autowired
	private AnimalDAO animalDao;
	
	@Override
	@Transactional
	public List<Proprietar> getProprietari() {
		return proprietarDAO.getProprietari();
	}

	@Override
	@Transactional
	public List<Animal> getAnimals() {		
		return animalDao.getAnimals();
	}

	@Override
	@Transactional
	public AnimalDetail getAnimalDetail(int id) {
		
		return animalDao.getAnimalDetail(id);
	}

	@Override
	@Transactional
	public void saveProprietar(Proprietar proprietar) {
		proprietarDAO.saveProprietar(proprietar);
		
	}

	@Override
	@Transactional
	public Proprietar getProprietar(int id) {
		
		return proprietarDAO.getProprietar(id);
	}

	@Override
	@Transactional
	public void deleteProprietar(int id) {
		proprietarDAO.deleteProprietar(id);		
	}

	@Override
	@Transactional
	public void saveAnimal(Animal animal, int proprietarId) {
		animalDao.saveAnimal(animal, proprietarId);		
	}
	

	@Override
	@Transactional
	public void deleteAnimal(int id) {
		animalDao.deleteAnimal(id);
		
	}

	

}
