package br.edu.ifpb.dac.exerciciojpa.dao.unidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Celular;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class CelularDAO extends DAO implements GenericDAO<Celular, Long> {

	@Override
	public void save(Celular obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Celular.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Celular obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Celular.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Celular obj) throws ExercicioJpaPersistenceException {
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Celular.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Celular findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Celular result = null;
		try {
			result = em.find(Celular.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Celular pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Celular> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Celular> celulars = null;
		try {
			TypedQuery<Celular> query = em.createQuery("SELECT c FROM Celular_UNI c", Celular.class);
			celulars = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Celulares.", pe);
		} finally {
			em.close();
		}

		return celulars;
	}

}
