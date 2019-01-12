package com.eduardmatei.prolife.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.AnimalDetail;
import com.eduardmatei.prolife.entity.Proprietar;

@Repository
public class AnimalDAOImpl implements AnimalDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	@Autowired
	private ProprietarDAO proprietarDAO;
	
	@Override
	public List<Animal> getAnimals() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Animal> query = session.createQuery("from Animal order by id",Animal.class);
		
		List<Animal> animals = query.getResultList();
		
		return animals;
	}

	@Override
	public AnimalDetail getAnimalDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Animal animal = session.get(Animal.class, id);
		
		return animal.getAnimalDetail();
	}

	@Override
	public void saveAnimal(Animal animal) {
		
		Session session = sessionFactory.getCurrentSession();		
			
		
		session.saveOrUpdate(animal);
				
	}

	@Override
	public void addAnimalToProprietar(Animal animal, int proprietarId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Proprietar proprietar = session.get(Proprietar.class, proprietarId);
		
		proprietar.add(animal);
		
		
		
	}
	
	
	

}
