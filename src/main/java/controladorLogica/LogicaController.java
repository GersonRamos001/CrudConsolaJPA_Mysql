package controladorLogica;

import DAO.ControladoraPersistencia;
import java.util.List;
import model.Carrera;
import model.Credencial;
import model.Estudiante;
import model.Materia;

public class LogicaController {

    /*
    LLAMANDO CONTROLADOR
     */
    ControladoraPersistencia controlador = new ControladoraPersistencia();

    /*
    CREDENCIAL
     */
    public void crearCredencial(Credencial cred) {
        controlador.crearCredencial(cred);
    }

    public void eliminarCredencial(int id) {
        controlador.eliminarCredencial(id);
    }

    public void modificarCredencial(Credencial cred) {
        controlador.editarCredencial(cred);
    }

    public Credencial leerCredencial(int id) {

        return controlador.leerCredencial(id);
    }

    public List<Credencial> leerTodasCredencial() {

        return controlador.leerTodasCredencial();
    }

    /*
    CARRERA
     */
    public void crearCarrera(Carrera carr) {
        controlador.crearCarrera(carr);
    }

    public void eliminarCarrera(int id) {
        controlador.eliminarCarrera(id);
    }

    public void modificarCarrera(Carrera carr) {
        controlador.editarCarrera(carr);
    }

    public Carrera leerCarrera(int id) {

        return controlador.leerCarrera(id);
    }

    public List<Carrera> leerTodasCarreras() {

        return controlador.leerTodasCarreras();
    }

    /*
    MATERIA
     */
    public void crearMateria(Materia mate) {
        controlador.crearMateria(mate);
    }

    public void eliminarMateria(int id) {
        controlador.eliminarMateria(id);
    }

    public void modificarMateria(Materia mate) {
        controlador.editarMateria(mate);
    }

    /*
    ESTUDIANTE
     */
    public void crearEstudiante(Estudiante estu) {
        controlador.crearEstudiante(estu);
    }

    public void eliminarEstudiante(int id) {
        controlador.eliminarEstudiante(id);
    }

    public void modificarEstudiante(Estudiante estu) {
        controlador.editarEstudiante(estu);
    }

}
