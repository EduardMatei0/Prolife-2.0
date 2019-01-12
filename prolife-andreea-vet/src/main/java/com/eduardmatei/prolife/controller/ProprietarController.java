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
import com.sun.xml.bind.v2.model.core.ID;


@Controller
@RequestMapping("/proprietar")
public class ProprietarController {
	
	@Autowired
	private ProlifeService prolifeService;
	
	private static int id;
	
	@GetMapping("/list")
	public String listProprietari(Model model) {
		
		List<Proprietar> proprietars = prolifeService.getProprietari();
		
		model.addAttribute("proprietari", proprietars);
		
		return "list-proprietari";
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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Proprietar proprietar = new Proprietar();
		
		model.addAttribute("proprietar", proprietar);
		
		return "proprietar-form";
	}
	
	
	@GetMapping("/showFormForAddAnimal")	
	public String showFormForAddAnimal(@RequestParam("proprietarId") int id , Model model) {
		
		Animal animal = new Animal();			
		
		Proprietar proprietar = prolifeService.getProprietar(id);
		
		this.id = id;		
	
		model.addAttribute("animal", animal);
		model.addAttribute("proprietar", proprietar);
		
		System.out.println("Proprietar id: " + proprietar.getId());
		System.out.println("Proprietar: " + proprietar);
		System.out.println("Static id: " + this.id);
		
		return "animal-form";
	} 
	
	@PostMapping("/saveProprietar")
	public String saveProprietar(@ModelAttribute("proprietar") Proprietar proprietar) {
		
		
		
		prolifeService.saveProprietar(proprietar);
		
		return "redirect:/proprietar/list";
	} 
	
	@PostMapping("/saveAnimal")
	public String saveAnimal(@ModelAttribute("animal") Animal animal, Integer proprietarId) {
		
		System.out.println("Animal: " + animal);
		System.out.println("Proprietar: " + animal.getProprietar());
		
		proprietarId = this.id;
		
		System.out.println("Parameter id: " + proprietarId);
		
		prolifeService.saveAnimal(animal, proprietarId);
		
		return "redirect:/proprietar/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("proprietarId") int id,
			Model model) {

		
		Proprietar proprietar = prolifeService.getProprietar(id);	
		
		
		model.addAttribute("proprietar", proprietar);
		
			
		return "proprietar-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteProprietar(@RequestParam("proprietarId") int id) {
		
		// delete the customer
		prolifeService.deleteProprietar(id);
		
		return "redirect:/proprietar/list";
	}
	
	@GetMapping("/deleteAnimal")
	public String deleteAnimal(@RequestParam("animalId") int id) {
		
		// delete the customer
		prolifeService.deleteAnimal(id);
		
		return "redirect:/proprietar/animals";
	}
}
