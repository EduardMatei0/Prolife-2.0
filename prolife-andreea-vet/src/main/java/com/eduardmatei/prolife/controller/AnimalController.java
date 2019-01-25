package com.eduardmatei.prolife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.Proprietar;
import com.eduardmatei.prolife.service.AnimalService;
import com.eduardmatei.prolife.service.ProprietarService;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	
	private final AnimalService animalService;
	private final ProprietarService proprietarService;
	
	
	@Autowired
	public AnimalController(AnimalService animalService, ProprietarService proprietarService) {
		this.proprietarService = proprietarService;
		this.animalService = animalService;
	}

	@GetMapping("/animals")
	public String getAnimals(Model model) {
		List<Animal> animals = animalService.getAnimals();
		
		model.addAttribute("animals", animals);
		
		return "animal-list";
	}
	
	
	
	@GetMapping("/showFormForAddAnimal")	
	public String showFormForAddAnimal(@RequestParam("proprietarId") int id , Model model) {
		
		Animal animal = new Animal();			
		
		Proprietar proprietar = proprietarService.getProprietar(id);					
		model.addAttribute("animal", animal);
		model.addAttribute("proprietar", proprietar);
		
		return "animal-form";
	} 
	
	@PostMapping("/saveAnimal")
	public String saveAnimal(@ModelAttribute("animal") Animal animal,@RequestParam("proprietarId") Integer proprietarId) {
		
		System.out.println("Animal: " + animal);
		System.out.println("Proprietar: " + animal.getProprietar());
		
		
		System.out.println("Parameter id: " + proprietarId);
		
		animalService.saveAnimal(animal, proprietarId);
		
		return "redirect:/animal/animals";
		
	}
	
	@GetMapping("/deleteAnimal")
	public String deleteAnimal(@RequestParam("animalId") int id) {
		
		// delete the customer
		animalService.deleteAnimal(id);
		
		return "redirect:/animal/animals";
	}
}
