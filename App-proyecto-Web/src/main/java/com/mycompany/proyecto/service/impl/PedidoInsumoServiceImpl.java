package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.PedidoRepository;
import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.model.PedidoDetalle;
import com.mycompany.proyecto.service.PedidoInsumoService;
/**
 * Implementacion del Servicio Pedido para la 
 * entidad del mismo
 *
 * @author Rodrigo Garcete
 * @since 21/11/2012
 */
@Service
public class PedidoInsumoServiceImpl implements PedidoInsumoService {
	
	private PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoInsumoServiceImpl(PedidoRepository pr){
		this.pedidoRepository = pr;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Pedido findById(Long codigo) throws DataAccessException {
		return pedidoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findByName(String nombre) throws DataAccessException {
		return pedidoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Pedido b) throws DataAccessException {
		pedidoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> getAll() throws DataAccessException {
		return pedidoRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Pedido c) throws DataAccessException {
		pedidoRepository.remove(c);
		return true;
	}

	@Override
	@Transactional
	public void savePedido(Pedido p, List<PedidoDetalle> listaItems)
			throws DataAccessException {
		pedidoRepository.savePedido(p, listaItems);
	}

	@Override
	public List<PedidoDetalle> findPedidoDetalles(Long codigo)
			throws DataAccessException {
		return null;
	}

}
