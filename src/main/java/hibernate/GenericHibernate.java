package hibernate;

import com.videogameshop.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class GenericHibernate {

    private final EntityManagerFactory entityManagerFactory;


    public GenericHibernate(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void createP(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> void create(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
