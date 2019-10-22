package com.restproject.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.restproject.model.Professor;

public class ProfessorRepositoryImpli implements ProfessorRepository {

	@Autowired
	private RestTemplate restTemplate;

	private String URL_API_PROFESSOR = "https://projetoifhelp.herokuapp.com/api/professor/";

	public ProfessorRepositoryImpli() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public List<Professor> getAll() {
		try {
			ResponseEntity<Professor[]> response = this.restTemplate.getForEntity(URL_API_PROFESSOR, Professor[].class);
			if (response.getStatusCodeValue() == 200) {
				return Arrays.stream(response.getBody()).collect(Collectors.toList());
			}
		} catch (HttpClientErrorException ex) {

			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				return null;
			}
		}
		return null;
	}

	@Override
	public Professor getById(long id) {
		ResponseEntity<Professor> response = null;

		try {
			response = this.restTemplate.getForEntity(URL_API_PROFESSOR + "/" + id, Professor.class);
			if (response.getStatusCode().is2xxSuccessful()) {
				return response.getBody();
			}
		} catch (HttpClientErrorException ex) {

			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				return null;
			}
		}
		return null;
	}

	@Override
	public Professor save(Professor professor) {
		return restTemplate.postForObject(URL_API_PROFESSOR, professor, Professor.class);
	}

	@Override
	public void update(long id, Professor professor) {
		restTemplate.put(URL_API_PROFESSOR+"/"+id, professor);
	}

	@Override
	public void delete(long id) {
		restTemplate.delete(URL_API_PROFESSOR+"/"+id);
	}

}
