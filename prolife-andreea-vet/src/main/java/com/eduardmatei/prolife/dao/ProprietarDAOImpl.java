package com.eduardmatei.prolife.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.Proprietar;

@Repository
public class ProprietarDAOImpl implements ProprietarDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AnimalDAO animalDAO;
	
	@Override
	public List<Proprietar> getProprietari() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Proprietar> query = session.createQuery("from Proprietar order by id",Proprietar.class);
		
		List<Proprietar> proprietars = query.getResultList();
		
		return proprietars;
	}

	@Override
	public void saveProprietar(Proprietar proprietar) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(proprietar);
		
	}

	@Override
	public Proprietar getProprietar(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Proprietar proprietar = session.get(Proprietar.class, id);
		
		return proprietar;
	}

	@Override
	public void deleteProprietar(int id) {
		Session session = sessionFactory.getCurrentSession();
				
		Proprietar proprietar = session.get(Proprietar.class, id);
		
		if (proprietar.getAnimals() != null) {
			for (Animal animal : proprietar.getAnimals()) {
				animalDAO.deleteAnimal(animal.getId());
			}
		}

		session.delete(proprietar);
		
		
	}

}
