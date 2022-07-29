package com.microservicemysql.services;

import java.util.Optional;

import com.microservicemysql.models.entity.AlumnoEntity;

public interface UsuarioService {
	
	public Iterable<AlumnoEntity> findAll();
	
	public Optional<AlumnoEntity> findById(Long id);
	
	public AlumnoEntity save(AlumnoEntity usuario);
	
	public void deleteById(Long id);
	
}
