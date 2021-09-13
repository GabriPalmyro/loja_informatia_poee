package com.projeto.model.service;
 
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto.model.model.Cliente;
import com.projeto.model.repository.ClienteDao;
import com.projeto.persistence.ConexaoBancoDeDados;

public class ClienteService {
	
	private static final String UNIT_NAME = "projeto";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private EntityManager entityManager;
	
	
	private ClienteDao clienteDao;
	
	public ClienteService() {
		this.entityManager = null;
	}
	
	private void abrirBancoDados() {
		
		if(Objects.isNull(this.entityManager)) {
			setEntityManager(ConexaoBancoDeDados.getConexao().getEntityManager());
		}
		
		if(!this.entityManager.isOpen()) {
			setEntityManager(ConexaoBancoDeDados.getConexao().getEntityManager());
		}

		clienteDao = new ClienteDao(this.entityManager);
	}
	
	private void fecharBancoDados() {
		if(this.getEntityManager().isOpen()) {
			this.getEntityManager().close();
		}
	}
	
	public void save(Cliente cliente) {
		
		abrirBancoDados();
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			clienteDao.save(cliente);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
		} finally {
			fecharBancoDados();
		}
		
	}
	
	public void update(Cliente cliente) {
		
		abrirBancoDados();
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			clienteDao.update(cliente);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
		} finally {
			fecharBancoDados();
		}
		
	}
	
	public void delete(Cliente cliente) {
		
		abrirBancoDados();
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			clienteDao.delete(cliente);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
		} finally {
			fecharBancoDados();
		}
		
	}
	
 	public Cliente findClienteById(Integer id) {
 			
		abrirBancoDados();
 		Cliente cliente = clienteDao.findById(id);
 		fecharBancoDados();
 		return cliente;
 	}
 	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Integer countTotalRegistroClientes() {
		abrirBancoDados();
		return clienteDao.countTotalRegistrosClientes();
	}

	public List<Cliente> carregarListaCliente(Integer paginaAtual, Integer registrosPorPagina) {
		abrirBancoDados();
		return clienteDao.listaClientePorPaginacao(paginaAtual, registrosPorPagina);
	}
}
