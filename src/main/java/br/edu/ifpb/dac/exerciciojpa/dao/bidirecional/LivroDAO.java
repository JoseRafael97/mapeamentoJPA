package br.edu.ifpb.dac.exerciciojpa.dao.bidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Livro;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class LivroDAO extends DAO implements GenericDAO<Livro, Long> {

	@Override
	public void save(Livro obj) throws ExercicioJpaPersistenceException {

		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Livro.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Livro obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Livro.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Livro obj) throws ExercicioJpaPersistenceException {
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Livro.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Livro findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Livro result = null;
		try {
			result = em.find(Livro.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Livro pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Livro> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Livro> livros = null;
		try {
			TypedQuery<Livro> query = em.createQuery("SELECT p FROM Livro_BI p", Livro.class);
			livros = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Livros.", pe);
		} finally {
			em.close();
		}

		return livros;
	}

}
