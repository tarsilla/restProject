package com.restproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restproject.resource.ProfessorResource;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorResource resource;
	
	
	
}
