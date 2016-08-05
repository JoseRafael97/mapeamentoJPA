package br.edu.ifpb.dac.exerciciojpa.dao.bidirecional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dac.exerciciojpa.dao.DAO;
import br.edu.ifpb.dac.exerciciojpa.dao.GenericDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Projeto;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class ProjetoDAO extends DAO implements GenericDAO<Projeto, Long> {

	@Override
	public void save(Projeto obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar persistir Projeto.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Projeto obj) throws ExercicioJpaPersistenceException {
		EntityManager em = this.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(obj);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
			throw new ExercicioJpaPersistenceException("Erro ao tentar atualizar Projeto.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Projeto obj) throws ExercicioJpaPersistenceException {
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
			throw new ExercicioJpaPersistenceException("Erro ao tentar remover Projeto.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Projeto findById(Long id) throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		Projeto result = null;
		try {
			result = em.find(Projeto.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar Projeto pelo id.", pe);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<Projeto> findAll() throws ExercicioJpaPersistenceException {
		EntityManager em = getEntityManager();
		List<Projeto> Projetos = null;
		try {
			TypedQuery<Projeto> query = em.createQuery("SELECT d FROM Projeto_BI d", Projeto.class);
			Projetos = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new ExercicioJpaPersistenceException("Erro ao buscar todos os Projetos.", pe);
		} finally {
			em.close();
		}

		return Projetos;
	}

}