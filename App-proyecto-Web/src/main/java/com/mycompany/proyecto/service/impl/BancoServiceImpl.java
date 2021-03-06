package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.BancoRepository;
import com.mycompany.proyecto.model.Banco;
import com.mycompany.proyecto.service.BancoService;
/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class BancoServiceImpl implements BancoService {
	
	private BancoRepository bancoRepository;
	
	@Autowired
	public BancoServiceImpl(BancoRepository br){
		this.bancoRepository = br;
	}

	@Override
	@Transactional(readOnly = true)
	public Banco findById(Long codigo) throws DataAccessException {
		return bancoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Banco> findByName(String nombre) throws DataAccessException {
		return null;
				//bancoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Banco b) throws DataAccessException {
		bancoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Banco> getAll() throws DataAccessException {
		return bancoRepository.findAll();
	}

	@Override
	public Boolean remove(Banco c) throws DataAccessException {
		bancoRepository.remove(c);
		return true;
	}

}