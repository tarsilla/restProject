package com.restproject.model;

public class Professor{
	
	private Integer id;
	private String nome;
	private String matricula;
	private String email;
	
	public Professor(Integer id,String nome, String matricula, String email) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
