package com.eduardmatei.prolife.dao;

import java.util.List;

import com.eduardmatei.prolife.entity.AnimalDetail;

public interface AnimalDetailDAO {
	
	public void saveAnimalDetail(AnimalDetail animalDetail, int animalId);
	
	public List<AnimalDetail> getAnimalDetails(int id);
	
}
