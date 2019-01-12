package com.eduardmatei.prolife.dao;

import java.util.List;

import com.eduardmatei.prolife.entity.Proprietar;


public interface ProprietarDAO {
	public List<Proprietar> getProprietari();
	
	public void saveProprietar(Proprietar proprietar);

	public Proprietar getProprietar(int id);

	public void deleteProprietar(int id);
}
