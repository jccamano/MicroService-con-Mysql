package com.app.microserviciocursos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microserviciocursos.models.entity.CursoEntity;
import com.app.microserviciocursos.models.repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<CursoEntity> findAll() {		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CursoEntity> findById(Long id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public CursoEntity save(CursoEntity curso) {
		
		return repository.save(curso);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {		
		repository.deleteById(id);
		
	}

}
