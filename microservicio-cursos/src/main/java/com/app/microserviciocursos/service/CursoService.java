package com.app.microserviciocursos.service;

import java.util.Optional;

import com.app.microserviciocursos.models.entity.CursoEntity;

public interface CursoService {
	
	public Iterable<CursoEntity> findAll();

	public Optional<CursoEntity> findById(Long id);
	
	public CursoEntity save(CursoEntity curso);
	
	public void deleteById (Long id);
	

}
