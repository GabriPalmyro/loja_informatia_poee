package com.projeto.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto.model.model.Aparelho;
import com.projeto.model.model.Cliente;

public class AparelhoDao {

	private EntityManager entityManager;

	public AparelhoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Aparelho aparelho) {
		this.getEntityManager().persist(aparelho);
	}
	
	public void update(Aparelho aparelho) {
		this.getEntityManager().merge(aparelho);
	}
	
	public void delete(Aparelho aparelho) {
		this.getEntityManager().remove(aparelho);
	}
	
	public Aparelho findById(Integer id) {
		return this.getEntityManager().find(Aparelho.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aparelho> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT a FROM Aparelho a");
		List<Aparelho> listaAparelho = query.getResultList(); 
		return listaAparelho;
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
