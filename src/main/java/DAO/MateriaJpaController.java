/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Materia;

/**
 *
 * @author UFG
 */
public class MateriaJpaController implements Serializable {

    public MateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
         public MateriaJpaController (){
        this.emf = Persistence.createEntityManagerFactory("crudGuia9");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materia materia) {
        if (materia.getListaEstudiantes() == null) {
            materia.setListaEstudiantes(new ArrayList<Estudiante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Estudiante> attachedListaEstudiantes = new ArrayList<Estudiante>();
            for (Estudiante listaEstudiantesEstudianteToAttach : materia.getListaEstudiantes()) {
                listaEstudiantesEstudianteToAttach = em.getReference(listaEstudiantesEstudianteToAttach.getClass(), listaEstudiantesEstudianteToAttach.getIdEstudiante());
                attachedListaEstudiantes.add(listaEstudiantesEstudianteToAttach);
            }
            materia.setListaEstudiantes(attachedListaEstudiantes);
            em.persist(materia);
            for (Estudiante listaEstudiantesEstudiante : materia.getListaEstudiantes()) {
                listaEstudiantesEstudiante.getListaMaterias().add(materia);
                listaEstudiantesEstudiante = em.merge(listaEstudiantesEstudiante);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materia materia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materia persistentMateria = em.find(Materia.class, materia.getIdMateria());
            List<Estudiante> listaEstudiantesOld = persistentMateria.getListaEstudiantes();
            List<Estudiante> listaEstudiantesNew = materia.getListaEstudiantes();
            List<Estudiante> attachedListaEstudiantesNew = new ArrayList<Estudiante>();
            for (Estudiante listaEstudiantesNewEstudianteToAttach : listaEstudiantesNew) {
                listaEstudiantesNewEstudianteToAttach = em.getReference(listaEstudiantesNewEstudianteToAttach.getClass(), listaEstudiantesNewEstudianteToAttach.getIdEstudiante());
                attachedListaEstudiantesNew.add(listaEstudiantesNewEstudianteToAttach);
            }
            listaEstudiantesNew = attachedListaEstudiantesNew;
            materia.setListaEstudiantes(listaEstudiantesNew);
            materia = em.merge(materia);
            for (Estudiante listaEstudiantesOldEstudiante : listaEstudiantesOld) {
                if (!listaEstudiantesNew.contains(listaEstudiantesOldEstudiante)) {
                    listaEstudiantesOldEstudiante.getListaMaterias().remove(materia);
                    listaEstudiantesOldEstudiante = em.merge(listaEstudiantesOldEstudiante);
                }
            }
            for (Estudiante listaEstudiantesNewEstudiante : listaEstudiantesNew) {
                if (!listaEstudiantesOld.contains(listaEstudiantesNewEstudiante)) {
                    listaEstudiantesNewEstudiante.getListaMaterias().add(materia);
                    listaEstudiantesNewEstudiante = em.merge(listaEstudiantesNewEstudiante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materia.getIdMateria();
                if (findMateria(id) == null) {
                    throw new NonexistentEntityException("The materia with id " + id + " no longer exists.");
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
            Materia materia;
            try {
                materia = em.getReference(Materia.class, id);
                materia.getIdMateria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materia with id " + id + " no longer exists.", enfe);
            }
            List<Estudiante> listaEstudiantes = materia.getListaEstudiantes();
            for (Estudiante listaEstudiantesEstudiante : listaEstudiantes) {
                listaEstudiantesEstudiante.getListaMaterias().remove(materia);
                listaEstudiantesEstudiante = em.merge(listaEstudiantesEstudiante);
            }
            em.remove(materia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materia> findMateriaEntities() {
        return findMateriaEntities(true, -1, -1);
    }

    public List<Materia> findMateriaEntities(int maxResults, int firstResult) {
        return findMateriaEntities(false, maxResults, firstResult);
    }

    private List<Materia> findMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materia.class));
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

    public Materia findMateria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materia.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materia> rt = cq.from(Materia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
