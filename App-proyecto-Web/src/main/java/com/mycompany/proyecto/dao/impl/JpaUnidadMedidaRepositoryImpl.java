package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.UnidadMedidaRepository;
import com.mycompany.proyecto.model.UnidadMedida;
/**
 * Implementacion de JPA de la interfaz {@link UnidadMedidaRepository}
 * @author Rodrigo Garcete
 * @since 21-11-2013
 */
@Repository
public class JpaUnidadMedidaRepositoryImpl extends BaseDao<UnidadMedida, Serializable> implements UnidadMedidaRepository {
	
	@SuppressWarnings("unchecked")
	public List<UnidadMedida> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("UnidadMedida.findByName");
        query.setParameter("nombre", nombre + "%");
        return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UnidadMedida> findByCombo() throws DataAccessException {
		return entityManager.createNamedQuery("UnidadMedida.findByCombo").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UnidadMedida> findAll() {
		return entityManager.createNamedQuery("UnidadMedida.findByAll").getResultList();
	}
	
}