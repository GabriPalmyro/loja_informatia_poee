package com.projeto.model.service;
 
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto.model.model.Aparelho;
import com.projeto.model.repository.AparelhoDao;
import com.projeto.persistence.ConexaoBancoDeDados;

public class AparelhoService {
	
	private static final String UNIT_NAME = "projeto";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private  EntityManager entityManager;
	
	
	private AparelhoDao aparelhoDao;
	
	public AparelhoService() {
		this.entityManager = null;
	}
	
	private void abrirBancoDados() {
		
		if(Objects.isNull(this.entityManager)) {
			setEntityManager(ConexaoBancoDeDados.getConexao().getEntityManager());
		}
		
		if(!this.entityManager.isOpen()) {
			setEntityManager(ConexaoBancoDeDados.getConexao().getEntityManager());
		}

		aparelhoDao = new AparelhoDao(this.entityManager);
	}
	
	private void fecharBancoDados() {
		if(this.getEntityManager().isOpen()) {
			this.getEntityManager().close();
		}
	}
	
	public void save(Aparelho aparelho) {
		
		abrirBancoDados();
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			aparelhoDao.save(aparelho);
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
	
	public void update(Aparelho aparelho) {
		
		abrirBancoDados();
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			aparelhoDao.update(aparelho);
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
	
	public void delete(Aparelho aparelho) {
		
		abrirBancoDados();
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			aparelhoDao.delete(aparelho);
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
	
	public Aparelho findClienteById(Integer id) {
			
		abrirBancoDados();
 		Aparelho aparelho = aparelhoDao.findById(id);
 		fecharBancoDados();
 		return aparelho;
 	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
