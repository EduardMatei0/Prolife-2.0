package com.eduardmatei.prolife.service;

import java.util.List;

import com.eduardmatei.prolife.entity.AnimalDetail;

public interface AnimalDetailService {
	
	public void saveAnimalDetail(AnimalDetail animalDetail, int animalId);
	
	public List<AnimalDetail> getAnimalDetails(int id);

}
