package com.restproject.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restproject.model.Professor;
import com.restproject.repository.ProfessorRepositoryImpli;

@RestController
@RequestMapping(value="/api ")
public class ProfessorResource {

	private ProfessorRepositoryImpli pri;
	
	public ProfessorResource() {
		this.pri = new ProfessorRepositoryImpli();
	}
	
	//Retorna uma lista de Professores
	@GetMapping("/professores")
	public List<Professor> listaProfessor(){
		return this.pri.getAll();
	}
	
	//Retorna um Professor Unico
	@GetMapping("/contatos/{id}")
	public Professor listaProfessorUnico(@PathVariable(value="id") long id) {
		return this.pri.getById(id);
	}
	
	//Criar um Professor
	@PostMapping("/professores")
	public Professor salvaProfessor(@RequestBody @Valid Professor professor) {
		return this.pri.save(professor);
	}
	
	//Deleta um Professor
	@DeleteMapping("/professores/{id}")
	public void deletaProfessor(@PathVariable(value="id") long id) {
		this.pri.delete(id);
	}
	
	//Atualiza um Professor
	@PutMapping("/professores/{id}")
	public void atualizaProfessor(@PathVariable(value="id") long id,@RequestBody @Valid Professor professor) {
		this.pri.update(id, professor);
	}
	
}
