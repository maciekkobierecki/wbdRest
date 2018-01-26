package jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.jersey.spi.resource.Singleton;

@ApplicationScoped
public class MySqlConnector {
	private EntityManager em;
	
	public MySqlConnector() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProductPU");
		em=emf.createEntityManager();
	}
	
	public void createProduct() {
		Product product=new Product(15,"ekstra", "super", 35,20,11,15,22,33);
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}
}
