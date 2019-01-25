package com.eduardmatei.prolife.service;

import java.util.List;

import com.eduardmatei.prolife.entity.Proprietar;

public interface ProprietarService {
	
	public List<Proprietar> getProprietari();
	
	public void saveProprietar(Proprietar proprietar);

	public Proprietar getProprietar(int id);

	public void deleteProprietar(int id);		

	public List<Proprietar> searchProprietars(String name);
	
	
}
