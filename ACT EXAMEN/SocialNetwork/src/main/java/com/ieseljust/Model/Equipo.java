package com.ieseljust.Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author ivan
 */
@Entity
@Table(name = "Equipo")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipo")
    private int idEquipo;
    
    @Column(name = "nombre")
    private String nombre;
    //Relaciones
    //1:1 -> Equipo/Presidente
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
    name="idFundador",
    referencedColumnName = "idPresidente",
    unique=true,
    foreignKey = @ForeignKey(name = "FK_EQP_PRE"))
    private President fundador;
    
    //Relaciones
    //1:M -> Equipo/Jugador
    @OneToMany(mappedBy="elEquipo",
    cascade=CascadeType.PERSIST,
    fetch = FetchType.LAZY)
    private Set<Jugador> elsJugadors;
    
    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return idEquipo;
    }

    public void setId(int Equipo) {
        this.idEquipo = Equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", nombre=" + nombre + '}';
    }
    
    
}
