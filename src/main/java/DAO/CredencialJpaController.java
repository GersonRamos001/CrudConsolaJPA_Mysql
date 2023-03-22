/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Credencial;

/**
 *
 * @author UFG
 */
public class CredencialJpaController implements Serializable {

    public CredencialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
        public CredencialJpaController (){
        this.emf = Persistence.createEntityManagerFactory("crudGuia9");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Credencial credencial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(credencial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Credencial credencial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            credencial = em.merge(credencial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = credencial.getIdCredencial();
                if (findCredencial(id) == null) {
                    throw new NonexistentEntityException("The credencial with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Credencial credencial;
            try {
                credencial = em.getReference(Credencial.class, id);
                credencial.getIdCredencial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The credencial with id " + id + " no longer exists.", enfe);
            }
            em.remove(credencial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Credencial> findCredencialEntities() {
        return findCredencialEntities(true, -1, -1);
    }

    public List<Credencial> findCredencialEntities(int maxResults, int firstResult) {
        return findCredencialEntities(false, maxResults, firstResult);
    }

    private List<Credencial> findCredencialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Credencial.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Credencial findCredencial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Credencial.class, id);
        } finally {
            em.close();
        }
    }

    public int getCredencialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Credencial> rt = cq.from(Credencial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
