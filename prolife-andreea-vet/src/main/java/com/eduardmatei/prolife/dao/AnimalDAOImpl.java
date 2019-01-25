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
public class AnimalDAOImpl implements AnimalDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	
	@Override
	public List<Animal> getAnimals() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Animal> query = session.createQuery("from Animal order by id",Animal.class);
		
		List<Animal> animals = query.getResultList();
		
		return animals;
	}

	

	@Override
	public void saveAnimal(Animal animal, int proprietarId) {
		
		Session session = sessionFactory.getCurrentSession();		
			
		Proprietar proprietar = session.get(Proprietar.class, proprietarId);
		
		proprietar.add(animal);
		
		session.saveOrUpdate(animal);
				
	}
	

	@Override
	public void deleteAnimal(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Animal animal = session.get(Animal.class, id);
		
		session.delete(animal);
		
	}
	
	@Override
	public Animal getAnimal(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Animal animal = session.get(Animal.class, id);
		
		return animal;
	}
	

}
