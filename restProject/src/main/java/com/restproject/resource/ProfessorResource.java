package com.restproject.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProfessorResource {
	
	private static final String URL_API_PROFESSOR = "https://projetoifhelp.herokuapp.com/api/professor/";
	
	@Autowired
	private RestTemplate restTemplate;

}
