package com.projeto.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto.model.model.Funcionario;


public class FuncionarioDao {

	private EntityManager entityManager;

	public FuncionarioDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Funcionario funcionario) {
		this.getEntityManager().persist(funcionario);
	}
	
	public void update(Funcionario funcionario) {
		this.getEntityManager().merge(funcionario);
	}
	
	public void delete(Funcionario funcionario) {
		this.getEntityManager().remove(funcionario);
	}
	
	public Funcionario findById(Integer id) {
		return this.getEntityManager().find(null, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT a FROM Cliente a");
		List<Funcionario> listaCliente = query.getResultList(); 
		return listaCliente;
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
