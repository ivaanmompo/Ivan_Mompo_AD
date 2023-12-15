package com.ieseljust.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author ivan
 */
@Entity
@Table(name = "President")
public class President implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPresident")
    private int idPresident;
    
    @Column(name = "nombre")
    private String nombre;
    

    public President() {
    }

    public President(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPresident() {
        return idPresident;
    }

    public void setIdPresident(int President) {
        this.idPresident = President;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "President{" + "idPresident=" + idPresident + ", nombre=" + nombre + '}';
    }
    
    
}