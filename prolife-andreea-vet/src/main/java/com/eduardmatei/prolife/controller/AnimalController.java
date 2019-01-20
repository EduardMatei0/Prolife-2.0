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
import com.eduardmatei.prolife.entity.AnimalDetail;
import com.eduardmatei.prolife.entity.Proprietar;
import com.eduardmatei.prolife.service.ProlifeService;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	
	private final ProlifeService prolifeService;
			
	
	@Autowired
	public AnimalController(ProlifeService prolifeService) {
		this.prolifeService = prolifeService;
	}

	@GetMapping("/animals")
	public String getAnimals(Model model) {
		List<Animal> animals = prolifeService.getAnimals();
		
		model.addAttribute("animals", animals);
		
		return "animal-list";
	}
	
	@GetMapping("/animaldetails")
	public String getAnimalDetail(@RequestParam("animalId") int id, Model model) {
				
		
		AnimalDetail animalDetail = prolifeService.getAnimalDetail(id);
		
		model.addAttribute("animalDetail",animalDetail);
		
		return "animal-details";
	}
	
	@GetMapping("/showFormForAddAnimal")	
	public String showFormForAddAnimal(@RequestParam("proprietarId") int id , Model model) {
		
		Animal animal = new Animal();			
		
		Proprietar proprietar = prolifeService.getProprietar(id);					
		model.addAttribute("animal", animal);
		model.addAttribute("proprietar", proprietar);
		
		return "animal-form";
	} 
	
	@PostMapping("/saveAnimal")
	public String saveAnimal(@ModelAttribute("animal") Animal animal,@RequestParam("proprietarId") Integer proprietarId) {
		
		System.out.println("Animal: " + animal);
		System.out.println("Proprietar: " + animal.getProprietar());
		
		
		System.out.println("Parameter id: " + proprietarId);
		
		prolifeService.saveAnimal(animal, proprietarId);
		
		return "redirect:/animal/animals";
		
	}
	
	@GetMapping("/deleteAnimal")
	public String deleteAnimal(@RequestParam("animalId") int id) {
		
		// delete the customer
		prolifeService.deleteAnimal(id);
		
		return "redirect:/animal/animals";
	}
}
