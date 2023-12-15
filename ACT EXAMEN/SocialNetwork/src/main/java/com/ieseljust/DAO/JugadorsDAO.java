
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import com.ieseljust.Model.Jugador;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class JugadorsDAO {

    Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();

    public JugadorsDAO() {

    }

    //insert
    public void insertJugador(Jugador Jugador) {
        try {
            laSesion.getTransaction().begin();
            laSesion.save(Jugador);
            laSesion.getTransaction().commit();
            System.out.println("Jugador inserted correctly");
        } catch (Exception e) {
            laSesion.getTransaction().rollback();
            System.out.println("Error inserting Jugador. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //delete
    public void deleteJugador(Jugador Jugador) {
        try {
            laSesion.getTransaction().begin();
            laSesion.delete(Jugador);
            laSesion.getTransaction().commit();
            System.out.println("Jugador deleted corrected");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Jugador. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //update
    public void updateJugador(int id) {
        try {
            laSesion.getTransaction().begin();

            Jugador jugadortoupdate = laSesion.get(Jugador.class, id);

            jugadortoupdate.setNombre("messi");
            jugadortoupdate.setPosicion("DEL");

            laSesion.saveOrUpdate(jugadortoupdate);

            laSesion.getTransaction().commit();

            System.out.println("Jugador updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Jugador. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    public void selectAll() {
        try {
            laSesion.getTransaction().begin();


            laSesion.getTransaction().commit();

            System.out.println("Jugador updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Jugador. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }
}

