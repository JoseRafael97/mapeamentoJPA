package br.edu.ifpb.dac.exerciciojpa.dao.bidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Colaborador;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class ColaboradorDAO extends DAO implements GenericDAO<Colaborador, Long> {

	@Override
	public void save(Colaborador obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Colaborador.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Colaborador obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Colaborador.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Colaborador obj) throws ExercicioJpaPersistenceException {
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Colaborador.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Colaborador findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Colaborador result = null;
		try {
			result = em.find(Colaborador.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Colaborador pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Colaborador> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Colaborador> colaboradors = null;
		try {
			TypedQuery<Colaborador> query = em.createQuery("SELECT d FROM Colaborador_BI d", Colaborador.class);
			colaboradors = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Colaboradors.", pe);
		} finally {
			em.close();
		}

		return colaboradors;
	}

}
