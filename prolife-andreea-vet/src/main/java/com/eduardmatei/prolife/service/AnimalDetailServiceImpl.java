package com.eduardmatei.prolife.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardmatei.prolife.dao.AnimalDetailDAO;
import com.eduardmatei.prolife.entity.AnimalDetail;

@Service
public class AnimalDetailServiceImpl implements AnimalDetailService {
	
	@Autowired
	private AnimalDetailDAO animalDetailDAO;
	
	@Override
	@Transactional
	public void saveAnimalDetail(AnimalDetail animalDetail, int animalId) {	
		
		animalDetailDAO.saveAnimalDetail(animalDetail, animalId);
		
	}

	@Override
	@Transactional
	public List<AnimalDetail> getAnimalDetails(int id) {
		
		return animalDetailDAO.getAnimalDetails(id);
		
	}

}
