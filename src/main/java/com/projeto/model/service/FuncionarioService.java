package com.projeto.model.service;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto.model.model.Funcionario;
import com.projeto.model.repository.FuncionarioDao;
import com.projeto.persistence.ConexaoBancoDeDados;

public class FuncionarioService {
	
	private static final String UNIT_NAME = "projeto";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	
	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService() {
		this.entityManager = ConexaoBancoDeDados.getConexao().getEntityManager();
		funcionarioDao = new FuncionarioDao(this.entityManager);
	}
	
	public void testeDeChamada() {
		System.out.println("Chamando pela tela de cadastro");
	}
	
	public void save(Funcionario funcionario) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			funcionarioDao.save(funcionario);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
		} finally {
			if(this.getEntityManager().isOpen()) {
				this.getEntityManager().close();
			}
		}
		
	}
	
	public void update(Funcionario funcionario) {
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			funcionarioDao.update(funcionario);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
		} finally {
			if(this.getEntityManager().isOpen()) {
				this.getEntityManager().close();
			}
		}
		
	}
	
	public void delete(Funcionario funcionario) {
		EntityTransaction trx = this.getEntityManager().getTransaction();
		
		try {
			trx.begin();
			funcionarioDao.delete(funcionario);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
		} finally {
			if(this.getEntityManager().isOpen()) {
				this.getEntityManager().close();
			}
		}
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
