package br.edu.ifpb.dac.exerciciojpa.dao.bidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Empregado;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class EmpregadoDAO extends DAO implements GenericDAO<Empregado, Long> {

	@Override
	public void save(Empregado obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Empregado.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Empregado obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Empregado.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Empregado obj) throws ExercicioJpaPersistenceException {
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
	public Empregado findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Empregado result = null;
		try {
			result = em.find(Empregado.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Empregados pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Empregado> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Empregado> empregados = null;
		try {
			TypedQuery<Empregado> query = em.createQuery("SELECT e FROM Empregado_BI e", Empregado.class);
			empregados = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Empregados.", pe);
		} finally {
			em.close();
		}

		return empregados;
	}

}
