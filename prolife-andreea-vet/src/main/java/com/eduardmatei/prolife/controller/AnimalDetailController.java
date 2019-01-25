package com.eduardmatei.prolife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eduardmatei.prolife.entity.Animal;
import com.eduardmatei.prolife.entity.AnimalDetail;
import com.eduardmatei.prolife.service.AnimalDetailService;
import com.eduardmatei.prolife.service.AnimalService;

@Controller
public class AnimalDetailController {
	
	private final AnimalDetailService animalDetailService;
	private final AnimalService animalService;
	
	@Autowired
	public AnimalDetailController(AnimalDetailService animalDetailService, AnimalService animalService) {
		this.animalService = animalService;
		this.animalDetailService = animalDetailService;
	}
	
	@GetMapping("/animal/animaldetails")
	public String getAnimalDetail(@RequestParam("animalId") int id, Model model) {
				
		
		List<AnimalDetail> animalDetails = animalDetailService.getAnimalDetails(id);
		Animal animal = animalService.getAnimal(id);
		model.addAttribute("animal", animal);
		model.addAttribute("animalDetails",animalDetails);
		
		return "animal-details";
	}
	
	@GetMapping("/showFormForAddAnimalDetail")	
	public String showFormForAddAnimal(@RequestParam("animalId") int id , Model model) {
		
		AnimalDetail animalDetail = new AnimalDetail();			
		
		Animal animal = animalService.getAnimal(id);
		
		model.addAttribute("animalDetail", animalDetail);
		model.addAttribute("animal", animal);
		
		return "animalDetail-form";
	} 
	
	@PostMapping("/saveAnimalDetail")
	public String saveAnimalDetail(@ModelAttribute("animalDetal") AnimalDetail animalDetail, 
												@RequestParam("animalId") Integer animalId) {
		
		animalDetailService.saveAnimalDetail(animalDetail, animalId);
		
		return "redirect:/animal/animals";
	}
}
