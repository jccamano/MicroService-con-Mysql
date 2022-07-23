package com.app.microserviciocursos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microserviciocursos.service.CursoService;

@RestController
@RequestMapping("/")
public class CursoControllers {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<?> getAllCourses(){
		return ResponseEntity.ok().body(service.findAll());
	}

}
