package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.DepartamentoRepository;
import com.mycompany.proyecto.model.Departamento;
import com.mycompany.proyecto.service.DepartamentoService;

/**
 * Capa de Servicio para Departamento
 *
 * @author Rodrigo Garcete
 * @since 21/11/2012
 */
@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	private DepartamentoRepository depRepository;
	
	@Autowired
	public DepartamentoServiceImpl(DepartamentoRepository cr){
		this.depRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento findById(Long codigo) throws DataAccessException {
		return depRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> findByName(String nombre) throws DataAccessException {
		return depRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Departamento b) throws DataAccessException {
		depRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> getAll() throws DataAccessException {
		return depRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Departamento c) throws DataAccessException {
		depRepository.remove(c);
		return true;
	}

	@Override
	public List<Departamento> findByCombo() throws DataAccessException {
		return depRepository.findByCombo();
	}

}
