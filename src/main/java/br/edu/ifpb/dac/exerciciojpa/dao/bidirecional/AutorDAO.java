package br.edu.ifpb.dac.exerciciojpa.dao.bidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Autor;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class AutorDAO extends DAO implements GenericDAO<Autor, Long> {

	@Override
	public void save(Autor obj) throws ExercicioJpaPersistenceException {

		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Autor.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Autor obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Autor.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Autor obj) throws ExercicioJpaPersistenceException {
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Autor.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Autor findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Autor result = null;
		try {
			result = em.find(Autor.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Autor pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Autor> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Autor> postagens = null;
		try {
			TypedQuery<Autor> query = em.createQuery("SELECT p FROM Autor_BI p", Autor.class);
			postagens = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Autores.", pe);
		} finally {
			em.close();
		}

		return postagens;
	}

}
