package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.FormaPago;

/**
 * Contrato de Persistencia para la entidad <code>Forma Pago</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface FormaPagoRepository extends Dao<FormaPago, Serializable> {
	
	List<FormaPago> findByName(String nombre) throws DataAccessException; 
	
}