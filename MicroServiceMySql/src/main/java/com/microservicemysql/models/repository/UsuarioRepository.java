package com.microservicemysql.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicemysql.models.entity.AlumnoEntity;

public interface UsuarioRepository extends CrudRepository<AlumnoEntity, Long> {

}
