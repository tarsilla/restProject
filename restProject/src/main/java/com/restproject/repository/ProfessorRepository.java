package com.restproject.repository;

import java.util.List;

import com.restproject.model.Professor;

public interface ProfessorRepository{

	List<Professor> getAll();

	Professor getById(long id);

	Professor save(Professor professor);

	void update(long id, Professor professor);

	void delete(long id);
}
