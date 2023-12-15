package com.ieseljust.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 *
 * @author ivan
 */
@Entity
@Table(name = "Posicion")
public class Posicion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPosicion")
    private int idPosicion;
    
    @Column(name = "nombre")
    private String nombre;
    
    //Relaciones
    //M:M -> Posicion/Jugador
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "posicion_jugador", 
        joinColumns = @JoinColumn(name = "idPosicion"), 
        inverseJoinColumns = @JoinColumn(name = "idJugador"))
    private Set<Jugador> Jugadors = new HashSet<>();
    
    public Posicion() {
    }

    public Posicion(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(int idPosicion) {
        this.idPosicion = idPosicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Posicion{" + "idPosicion=" + idPosicion + ", nombre=" + nombre + '}';
    }
    
    
}
