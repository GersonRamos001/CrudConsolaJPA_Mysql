package DAO;

import DAO.exceptions.NonexistentEntityException;
import controladorLogica.LogicaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrera;
import model.Credencial;
import model.Estudiante;
import model.Materia;

public class ControladoraPersistencia {

    /*
    LLAMANDO CONTROLLERS
     */
    CredencialJpaController credController = new CredencialJpaController();
    CarreraJpaController carreraController = new CarreraJpaController();
    MateriaJpaController materiaController = new MateriaJpaController();
    EstudianteJpaController estudianteController = new EstudianteJpaController();

    /*
    CRUD CREDENCIAL
     */
    public void crearCredencial(Credencial cred) {
        credController.create(cred);
    }

    public void editarCredencial(Credencial cred) {
        try {
            credController.edit(cred);
        } catch (Exception ex) {
            Logger.getLogger(LogicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Credencial leerCredencial(int id) {

        return credController.findCredencial(id);
    }

    public void eliminarCredencial(int id) {
        try {
            credController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LogicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Credencial> leerTodasCredencial() {
        return credController.findCredencialEntities();
    }

    /*
    CRUD CARRERA
     */
    public void crearCarrera(Carrera carr) {
        carreraController.create(carr);
    }

    public Carrera leerCarrera(int id) {
        return carreraController.findCarrera(id);
    }

    public void editarCarrera(Carrera carr) {
        try {
            carreraController.edit(carr);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCarrera(int id) {
        try {
            carreraController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Carrera> leerTodasCarreras() {
        return carreraController.findCarreraEntities();
    }

    /*
    CRUD MATERIA
     */
    public void crearMateria(Materia mate) {
        materiaController.create(mate);
    }

    public void editarMateria(Materia mate) {
        try {
            materiaController.edit(mate);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarMateria(int id) {
        try {
            materiaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    CRUD ESTUDIANTE
     */
    public void crearEstudiante(Estudiante estu) {
        estudianteController.create(estu);
    }

    public void editarEstudiante(Estudiante estu) {
        try {
            estudianteController.edit(estu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEstudiante(int id) {
        try {
            estudianteController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
