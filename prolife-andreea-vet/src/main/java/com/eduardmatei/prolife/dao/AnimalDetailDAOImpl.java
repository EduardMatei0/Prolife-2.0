package com.eduardmatei.prolife.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.AnimalDetail;

@Repository
public class AnimalDetailDAOImpl implements AnimalDetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAnimalDetail(AnimalDetail animalDetail, int animalId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Animal animal = session.get(Animal.class, animalId);
		
		animal.add(animalDetail);
		
		session.saveOrUpdate(animalDetail);
		
	}
	
	@Override
	public List<AnimalDetail> getAnimalDetails(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<AnimalDetail> query = session.createQuery("from AnimalDetail where animal_id=:animalId", AnimalDetail.class);
		
		query.setParameter("animalId", id);
		
		List<AnimalDetail> animalDetails = query.getResultList();
		
		return animalDetails;
	}
	
}
