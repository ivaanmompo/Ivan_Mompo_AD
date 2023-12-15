package com.ieseljust.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author ivan
 */

@Entity
@Table(name = "Jugador")
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idJugador")
    private int idJugador;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "posicion")
    private String posicion;
    
    //Relaciones
    //M:1 -> Jugador/Equipo
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="idEquip",
    foreignKey = @ForeignKey(name = "FK_JUG_EQP" ))
    private Equipo elEquipo;

    //Relaciones
    //M:M -> Jugador/Posicion
    @ManyToMany(mappedBy = "Jugador")
    private Set<Posicion> Posiciones = new HashSet<>();
    
    public Jugador() {
    }

    public Jugador(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" + "idJugador=" + idJugador + ", nombre=" + nombre + ", posicion=" + posicion + '}';
    }

    
}
