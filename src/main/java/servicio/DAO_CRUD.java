/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Carrera;
import model.Credencial;
import model.Estudiante;
import model.Materia;

public class DAO_CRUD {

    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("crudGuia9");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Credencial cred = new Credencial(1,"UFG");
        Credencial cred2 = new Credencial(2,"DON BOSCO");
        
         
        entitymanager.persist(cred);
        
//        Create Carrera Entity
        Carrera carrera1 = new Carrera();
        carrera1.setCodigo("DS2022");
        carrera1.setNombres("Desarrollo De Software");

        Carrera carrera2 = new Carrera();
        carrera2.setCodigo("PD2222");
        carrera2.setNombres("Psicologia Deportiva");
//
//        Store Carrera
//        System.out.println("carrera");
        entitymanager.persist(carrera1);
        entitymanager.persist(carrera2);
        
               //CREO LISTA DE ESTUDIANTES VACIOS
        List<Estudiante> listaEstudiante = new ArrayList();
        
        //        Create Materia Entity
        Materia materia1 = new Materia();
        materia1.setCodigo("POO01");
        materia1.setNombre("Programacion Orientada a objetos");
        materia1.setListaEstudiantes(listaEstudiante);

        Materia materia2 = new Materia();
        materia2.setCodigo("FE2022");
        materia2.setNombre("Framework empresariales");
        materia2.setListaEstudiantes(listaEstudiante);

        Materia materia3 = new Materia();
        materia3.setCodigo("EL2023");
        materia3.setNombre("Empredimiento y liderazgo");
        materia3.setListaEstudiantes(listaEstudiante);
        
   
        //        Store materia1
        System.out.println("materias");
        entitymanager.persist(materia1);
        entitymanager.persist(materia2);
        entitymanager.persist(materia3);
        
        //        Creo lista de materias
        List<Materia> listaMaterias = new ArrayList();
        listaMaterias.add(materia2);
        listaMaterias.add(materia1);
        listaMaterias.add(materia3);
        
        //Lista de materias 2
         List<Materia> listaMaterias2 = new ArrayList();
         listaMaterias2.add(materia2);
        
        
        
        //CREO Entidad Estudiante 
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombres("Gerson Vladimir");
        estudiante1.setApellidos("Ramos");
        estudiante1.setCarnet("RA102011");
        estudiante1.setIdCredential(cred);
        estudiante1.setIdCarrera(carrera1);
        estudiante1.setListaMaterias(listaMaterias);
        
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombres("Jose Antonio");
        estudiante2.setApellidos("Perez");
        estudiante2.setCarnet("RB25465");
        estudiante2.setIdCredential(cred2);
        estudiante2.setIdCarrera(carrera2);
        estudiante2.setListaMaterias(listaMaterias);
        
        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombres("Maria Josefina");
        estudiante3.setApellidos("Aguilar");
        estudiante3.setCarnet("MA20544");
        estudiante3.setIdCredential(cred);
        estudiante3.setIdCarrera(carrera1);
        estudiante3.setListaMaterias(listaMaterias2);



        entitymanager.persist(estudiante1);
        entitymanager.persist(estudiante2);
        entitymanager.persist(estudiante3);
                
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
        
        
    }
    
    
}
