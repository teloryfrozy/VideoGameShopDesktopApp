package com.videogameshop.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class GenericHibernate {

    private final EntityManagerFactory entityManagerFactory;

    public GenericHibernate(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


    //Persist = INSERT
    public <T> void create(T entity) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            System.out.println("Record created successfully");
        } catch (Exception e) {
            showAlert("Error creating record: ", e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    //merge = UPDATE
    public <T> void update(T entity) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            System.out.println("Record updated successfully");
        } catch (Exception e) {
            showAlert("Error updating record: ", e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public <T> List<T> getAllRecords(Class<T> className) {
        List<T> listOfRecords = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(className);
            Root<T> root = criteriaQuery.from(className);
            criteriaQuery.select(root);

            TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
            listOfRecords = query.getResultList();
        } catch (Exception e) {
            showAlert("Error getting records: ", e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listOfRecords;
    }


    public <T> void delete(Class<T> entityClass, int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            var object = em.find(entityClass, id);
            em.remove(object);
            em.getTransaction().commit();
            System.out.println("Record deleted successfully");
        } catch (Exception e) {
            showAlert("Error deleting record: ", e.getMessage());
        } finally {
            if (em != null) em.close();
        }
    }

    public <T> T getEntityById(Class<T> entityClass, int id) {
        EntityManager em = null;
        T result = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            result = em.find(entityClass, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            showAlert("Error getting record with id: " + id, e.getMessage());
        }
        return result;
    }
}