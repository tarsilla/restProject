package com.restproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restproject.model.Professor;
import com.restproject.repository.ProfessorRepositoryImpli;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	private ProfessorRepositoryImpli pri;
	
	public ProfessorController() {
		this.pri = new ProfessorRepositoryImpli();
	}
	
	
	@GetMapping
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView("/professores/Lista");
		mv.addObject("professores", pri.getAll());
		return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("/Professores/Novo");
		mv.addObject("professor", new Professor());
		return mv;
	}
	
	@PostMapping
	public String save(Professor professor) {
		pri.save(professor);
		return "redirect:/professores";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id){
		pri.delete(id);		
		return "redirect:/professores";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("/Professores/Editar");
		mv.addObject("professor",pri.getById(id));
		return mv;
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("id") long id, Professor professor) {
		pri.update(id, professor);
		return "redirect:/professores";
	}
}
