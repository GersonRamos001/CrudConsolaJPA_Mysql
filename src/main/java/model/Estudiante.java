/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "estudiante")

public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudiante")
    private Integer idEstudiante;
    

    @Column(name = "carnet")
    private String carnet;
    
   
    @Column(name = "nombres")
    private String nombres;
    

    @Column(name = "apellidos")
    private String apellidos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCarrera")
    private Carrera idCarrera;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCredencial")
    private Credencial idCredential;

    @JoinTable(
    name = "rel_estudiantes_materias",
    joinColumns = @JoinColumn(name = "FK_estudiantes", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "FK_Materias", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Materia> listaMaterias;
    
    public Estudiante() {
}

    public Estudiante(String carnet, String nombres, String apellidos, Carrera idCarrera, Credencial idCredential, List<Materia> listaMaterias) {
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idCarrera = idCarrera;
        this.idCredential = idCredential;
        this.listaMaterias = listaMaterias;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Credencial getIdCredential() {
        return idCredential;
    }

    public void setIdCredential(Credencial idCredential) {
        this.idCredential = idCredential;
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idEstudiante=" + idEstudiante + ", carnet=" + carnet + ", nombres=" + nombres + ", apellidos=" + apellidos + ", idCarrera=" + idCarrera + ", idCredential=" + idCredential + ", listaMaterias=" + listaMaterias + '}';
    }


    
    

}
