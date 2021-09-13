 package com.projeto.model.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto.model.model.Cliente;

public class ClienteDao {

	private EntityManager entityManager;

	public ClienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Cliente cliente) {
		this.getEntityManager().persist(cliente);
	}
	
	public void update(Cliente cliente) {
		this.getEntityManager().merge(cliente);
	}
	
	public void delete(Cliente cliente) {
		this.getEntityManager().remove(cliente);
	}
	
	public Cliente findById(Integer id) {
		return this.getEntityManager().find(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT a FROM Cliente a");
		List<Cliente> listaCliente = query.getResultList(); 
		return listaCliente;
	}
	
	public List<Cliente> listaClientePorPaginacao(int paginaAtual, int registrosPorPagina) {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		Query query = this.getEntityManager().createQuery("SELECT a FROM Cliente a")
					.setFirstResult(paginaAtual)
					.setMaxResults(registrosPorPagina);
		
		listaCliente = query.getResultList();
		return listaCliente;
	}
	
	public Integer countTotalRegistrosClientes() {
		Query query = this.getEntityManager().createQuery("SELECT count(a) FROM Cliente a");
		Long total = (Long) query.getSingleResult();
		return total.intValue();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
