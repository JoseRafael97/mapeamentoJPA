package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DAO {

	static EntityManagerFactory em;
	
	static {
		em = Persistence.createEntityManagerFactory("exercicio-jpa");
	}
	
	protected EntityManager getEntityManager() {
		return em.createEntityManager();
	}
	
	public void close() {
		em.close();
	}
}
