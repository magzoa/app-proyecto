package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.CiudadRepository;
import com.mycompany.proyecto.model.Ciudad;
import com.mycompany.proyecto.service.CiudadService;

/**
 * Servicio para Ciudad
 *
 * @author Rodrigo Garcete
 * @since 21/11/2012
 */
@Service
public class CiudadServiceImpl implements CiudadService {
	
	private CiudadRepository ciudadRepository;
	
	@Autowired
	public CiudadServiceImpl(CiudadRepository cr){
		this.ciudadRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Ciudad findById(Long codigo) throws DataAccessException {
		return ciudadRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findByName(String nombre) throws DataAccessException {
		return ciudadRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Ciudad b) throws DataAccessException {
		ciudadRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> getAll() throws DataAccessException {
		return ciudadRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Ciudad c) throws DataAccessException {
		ciudadRepository.remove(c);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findByCombo() throws DataAccessException {
		return ciudadRepository.findByCombo();
	}

}