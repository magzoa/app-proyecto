package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Empresa;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface EmpresaRepository {

	Empresa findById(Long codigo) throws DataAccessException;
	
	List<Empresa> findByName(String nombre) throws DataAccessException; 

	List<Empresa> getAll() throws DataAccessException;
		
	void save(Empresa empresa) throws DataAccessException;
		
	Boolean remove(Empresa empresa) throws DataAccessException;
	
}