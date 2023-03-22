/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "credencial")

public class Credencial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCredencial")
    private Integer idCredencial;

    @Column(name = "username")
    private String username;
    
   



	public Credencial() {
		super();
	}

	public Credencial(Integer idCredencial, String username) {
		super();
		this.idCredencial = idCredencial;
		this.username = username;
	}

	public Integer getIdCredencial() {
		return idCredencial;
	}

	public void setIdCredencial(Integer idCredencial) {
		this.idCredencial = idCredencial;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    @Override
    public String toString() {
        return "Credencial{" + "idCredencial=" + idCredencial + ", username=" + username + '}';
    }
        
        
    


}
