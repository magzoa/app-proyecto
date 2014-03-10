package com.mycompany.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Compra;
import com.mycompany.proyecto.model.CompraDetalle;

/**
 * Contrato de Persistencia para la entidad <code>Venta</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface CompraRepository {

	Compra findById(Long codigo) throws DataAccessException;
	
	List<Compra> findByName(String nombre) throws DataAccessException; 

	List<Compra> getAll() throws DataAccessException;
		
	void save(Compra compra) throws DataAccessException;
	
	void save(Compra compra, ArrayList<CompraDetalle> items) throws DataAccessException;
		
	Boolean remove(Compra compra) throws DataAccessException;
	
}