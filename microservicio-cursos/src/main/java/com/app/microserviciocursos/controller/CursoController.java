package com.app.microserviciocursos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microserviciocursos.models.entity.CursoEntity;
import com.app.microserviciocursos.service.CursoService;


@RestController
@RequestMapping("/")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<?> getAllCourses(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseById (@PathVariable Long id){
		Optional<CursoEntity> op = service.findById(id);
		
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}
	
	@PostMapping
	public ResponseEntity<?> createCourse(@RequestBody CursoEntity curso){
		CursoEntity cursoDB = service.save(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoDB);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editCourses(@RequestBody CursoEntity curso, @PathVariable Long id){
		Optional<CursoEntity> op = service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		CursoEntity cursoDB = op.get();
		cursoDB.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourses(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
	
	

}
