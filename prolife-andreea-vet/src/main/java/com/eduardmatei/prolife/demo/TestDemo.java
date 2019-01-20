package com.eduardmatei.prolife.demo;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.AnimalDetail;
import com.eduardmatei.prolife.entity.Proprietar;

public class TestDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Proprietar.class)
								.addAnnotatedClass(Animal.class)
								.addAnnotatedClass(AnimalDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			Animal animal1 = new Animal("Sasha", "Canina", "Metis", 1.1, new Date());	
//			AnimalDetail animalDetail1 = new AnimalDetail("clinic sanatos", "vaccin DHPPI", "fara observatii");
//			AnimalDetail animalDetail2 = new AnimalDetail("alopecie loco-regionala", "Imaverol", "tratement indelungat");
//			AnimalDetail animalDetail3 = new AnimalDetail("clinic sanatos", "vaccin NobivacRabies", "fara observatii");
//			AnimalDetail animalDetail4 = new AnimalDetail("clinic sanatos", "tuns si spalat", "agresiv");
//			
//			Animal animal2 = new Animal("Lola", "Canina", "Metis", 3.3, new Date());
//			Animal animal3 = new Animal("Cookie", "Felina", "Europeana", 5.0, new Date());
//			Animal animal4 = new Animal("Bubila", "Canina", "Metis", 4.5, new Date());
//			
//			animal1.setAnimalDetail(animalDetail1);
//			animal2.setAnimalDetail(animalDetail2);
//			animal3.setAnimalDetail(animalDetail3);
//			animal4.setAnimalDetail(animalDetail4);
//
//			
//			Proprietar proprietar1 = new Proprietar("Horhocea", "Alexandru", "0762980110", new Date());
//			Proprietar proprietar2 = new Proprietar("Nicu", "Catalina", "0745968070", new Date());
//			Proprietar proprietar3 = new Proprietar("Goran", "Daniel", "0726615113", new Date());
//			Proprietar proprietar4 = new Proprietar("Vlad", "Elena", "0723186539", new Date());
//			Proprietar proprietar5 = new Proprietar("Delia", "Bican", "0786674842", new Date());
//			

			
			
//			session.save(proprietar1);
//			session.save(proprietar2);
//			session.save(proprietar3);
//			session.save(proprietar4);
//			session.save(proprietar5);
//			
//
//			
//			System.out.println("Proprietar: " + proprietar5);
//			
//			proprietar1.add(animal1);
//			proprietar1.add(animal2);
//			proprietar2.add(animal3);
//			proprietar3.add(animal4);
//			
//			System.out.println("Saving animals: ");
//			
//			session.save(animal1);
//			session.save(animal2);
//			session.save(animal3);
//			session.save(animal4);
			
			session.beginTransaction();
			
			int id = 3;
			
			Animal animal = session.get(Animal.class, id);
			
			System.out.println("Animal: " + animal);
			System.out.println("Animal detail: " + animal.getAnimalDetail());
			session.delete(animal);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
