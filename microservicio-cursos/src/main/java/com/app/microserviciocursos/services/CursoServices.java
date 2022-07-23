package com.app.microserviciocursos.services;

import com.app.microserviciocursos.models.entity.CursoEntity;

public interface CursoServices {
	
	public Iterable<CursoEntity> findAll();
	
	

}
