package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.LoteRepository;
import com.mycompany.proyecto.model.Lote;
import com.mycompany.proyecto.service.LoteService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class LoteServiceImpl implements LoteService {
	
	private LoteRepository loteRepository;
	
	@Autowired
	public LoteServiceImpl(LoteRepository lr){
		this.loteRepository = lr;
	}

	@Override
	@Transactional(readOnly = true)
	public Lote findById(Long codigo) throws DataAccessException {
		return loteRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Lote> findByName(String nombre) throws DataAccessException {
		return loteRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Lote b) throws DataAccessException {
		loteRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Lote> getAll() throws DataAccessException {
		return loteRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Lote c) throws DataAccessException {
		loteRepository.remove(c);
		return true;
	}

}