package br.edu.ifpb.dac.exerciciojpa.dao.unidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Turista;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class TuristaDAO extends DAO implements GenericDAO<Turista, Long> {

	@Override
	public void save(Turista t) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(t);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Turista.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Turista obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Turista.", pe);
		} finally {
			em.close();
		}
	}
	
	public void remove(Turista obj) throws ExercicioJpaPersistenceException{
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Turista.", pe);
		} finally {
			em.close();
		}
	}


	@Override
	public Turista findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Turista result = null;
		try {
			result = em.find(Turista.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Turista pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Turista> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Turista> turistas = null;
		try {
			TypedQuery<Turista> query = em.createQuery("SELECT t FROM Turista_UNI t", Turista.class);
			turistas = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os turistas.", pe);
		} finally {
			em.close();
		}
		
		return turistas;
	}

	
}