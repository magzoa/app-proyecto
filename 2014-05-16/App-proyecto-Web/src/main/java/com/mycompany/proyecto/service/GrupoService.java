package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Grupo;

/**
 * Contrato de Persistencia para la entidad <code>Grupo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21-11-2013
 */
public interface GrupoService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Grupo findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Grupo> findByName(String nombre) throws DataAccessException; 
	
	List<Grupo> findByCombo() throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Grupo> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param banco
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Grupo g) throws DataAccessException;
		
	/**
	 * 
	 * @param banco
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Grupo g) throws DataAccessException;
	
}