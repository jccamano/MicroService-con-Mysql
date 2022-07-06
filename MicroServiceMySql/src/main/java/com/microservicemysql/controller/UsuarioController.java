package com.microservicemysql.controller;


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

import com.microservicemysql.models.entity.AlumnoEntity;
import com.microservicemysql.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Setter;

@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Operation(summary = "Ver todos los Alumnos.")
	@GetMapping	
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.ok().body(service.findAll());		
	}
	
	@Operation(summary = "Ver Alumno por Id.")
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id){
		
		Optional<AlumnoEntity> o = service.findById(id);		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@Operation(summary = "Registrar un Alumno a la Base de Datos.")
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody AlumnoEntity usario){
		AlumnoEntity usuarioDB = service.save(usario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDB);		
	}
	
	@Operation(summary = "Cambiar la informacion de un Alumno.")
	@PutMapping("/{id}")
	public ResponseEntity<?> editUsers(@RequestBody AlumnoEntity usuario, @PathVariable Long id){
		Optional<AlumnoEntity> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		AlumnoEntity usuarioDB = o.get();
		usuarioDB.setNombre(usuario.getNombre());
		usuarioDB.setApellido(usuario.getApellido());
		usuarioDB.setEmail(usuario.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDB));
	}
	
	@Operation(summary = "Borrar un Alumno.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsers(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}	

}
