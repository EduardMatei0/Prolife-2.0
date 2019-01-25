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
import com.eduardmatei.prolife.entity.Proprietar;
import com.eduardmatei.prolife.service.ProprietarService;



@Controller
@RequestMapping("/proprietar")
public class ProprietarController {
	
	
	private final ProprietarService proprietarService;
		
	@Autowired
	public ProprietarController(ProprietarService proprietarService) {
		this.proprietarService = proprietarService;
	}



	@GetMapping("/list")
	public String listProprietari(Model model) {
		
		List<Proprietar> proprietars = proprietarService.getProprietari();
		
		model.addAttribute("proprietari", proprietars);
		
		return "list-proprietari";
	}
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Proprietar proprietar = new Proprietar();
		
		model.addAttribute("proprietar", proprietar);
		
		return "proprietar-form";
	}
	
	
	
	
	@PostMapping("/saveProprietar")
	public String saveProprietar(@ModelAttribute("proprietar") Proprietar proprietar) {
					
		proprietarService.saveProprietar(proprietar);
		
		return "redirect:/proprietar/list";
	} 
	
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("proprietarId") int id,
			Model model) {

		
		Proprietar proprietar = proprietarService.getProprietar(id);	
		
		
		model.addAttribute("proprietar", proprietar);
		
			
		return "proprietar-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteProprietar(@RequestParam("proprietarId") int id) {
		
		// delete the customer
		proprietarService.deleteProprietar(id);
		
		return "redirect:/proprietar/list";
	}
	
	@PostMapping("/search")
	public String searchProprietar(@RequestParam("searchName") String name, Model model) {
		
		List<Proprietar> proprietars = proprietarService.searchProprietars(name);
		
		model.addAttribute("proprietari", proprietars);
		
		return "list-proprietari";
		
	}
	
	
}
