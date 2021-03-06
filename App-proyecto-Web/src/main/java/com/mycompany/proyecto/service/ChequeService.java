package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Cheque;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ChequeService {

	Cheque findById(Long codigo) throws DataAccessException;
	
	List<Cheque> findByName(String nombre) throws DataAccessException; 

	List<Cheque> getAll() throws DataAccessException;
		
	void save(Cheque cheque) throws DataAccessException;
		
	Boolean remove(Cheque cheque) throws DataAccessException;
	
}