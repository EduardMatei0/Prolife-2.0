package com.eduardmatei.prolife.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eduardmatei.prolife.dao.ProprietarDAO;
import com.eduardmatei.prolife.entity.Proprietar;

@Service
public class ProprietarServiceImpl implements ProprietarService {

	
	private final ProprietarDAO proprietarDAO;
		
	
	@Autowired
	public ProprietarServiceImpl(ProprietarDAO proprietarDAO) {
		this.proprietarDAO = proprietarDAO;
	}


	@Override
	@Transactional
	public List<Proprietar> getProprietari() {
		return proprietarDAO.getProprietari();
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
	public List<Proprietar> searchProprietars(String name) {
		
		return proprietarDAO.searchProprietari(name);
		
	}
	

}
