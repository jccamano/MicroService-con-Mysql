package com.app.microserviciocursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.microserviciocursos.models.entity.CursoEntity;

public interface CursoRepository  extends CrudRepository<CursoEntity, Long>{

}
