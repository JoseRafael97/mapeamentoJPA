package br.edu.ifpb.dac.exerciciojpa.dao.bidirecional;

import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Postagem;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;

public class PostagemDAO extends DAO implements GenericDAO<Postagem, Long>{
	
	@Override
	public void save(Postagem obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Postagem.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Postagem obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Postagem.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Postagem obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			obj = em.merge(obj);
			em.remove(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Postagem.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Postagem findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Postagem result = null;
		try {
			result = em.find(Postagem.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Postagem pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Postagem> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Postagem> postagens = null;
		try {
			TypedQuery<Postagem> query = em.createQuery("SELECT e FROM Postagem_BI e", Postagem.class);
			postagens = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Empregados.", pe);
		} finally {
			em.close();
		}
		
		return postagens;
	}

}
