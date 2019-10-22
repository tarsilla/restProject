package com.restproject.repository;

import java.util.List;

import com.restproject.model.Professor;

public interface ProfessorRepository{

	List<Professor> getAll();

	Professor getById(Integer id);

	Professor save(Professor professor);

	void update(Integer id, Professor professor);

	void delete(Integer id);
}
