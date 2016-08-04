package br.edu.ifpb.dac.exerciciojpa.dao.unidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Funcionario;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class FuncionarioDAO extends DAO implements GenericDAO<Funcionario, Long> {

	@Override
	public void save(Funcionario obj) throws ExercicioJpaPersistenceException {

		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Funcionario.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Funcionario obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Funcionario.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Funcionario obj) throws ExercicioJpaPersistenceException {
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Funcionario.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Funcionario findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Funcionario result = null;
		try {
			result = em.find(Funcionario.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Funcionario pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Funcionario> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Funcionario> funcionarios = null;
		try {
			TypedQuery<Funcionario> query = em.createQuery("SELECT p FROM Funcionario_UNI p", Funcionario.class);
			funcionarios = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Fucionarios.", pe);
		} finally {
			em.close();
		}

		return funcionarios;
	}
}
