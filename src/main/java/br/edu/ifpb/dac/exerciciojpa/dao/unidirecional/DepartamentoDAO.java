package br.edu.ifpb.dac.exerciciojpa.dao.unidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Departamento;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;

public class DepartamentoDAO extends DAO implements GenericDAO<Departamento, Long> {

	@Override
	public void save(Departamento obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Dapartamento.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Departamento obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Departamento.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Departamento obj) throws ExercicioJpaPersistenceException {
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Departamento.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Departamento findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Departamento result = null;
		try {
			result = em.find(Departamento.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Departamento pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Departamento> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Departamento> departamentos = null;
		try {
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento_UNI d", Departamento.class);
			departamentos = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os departamentos.", pe);
		} finally {
			em.close();
		}
		
		return departamentos;
	}

}
