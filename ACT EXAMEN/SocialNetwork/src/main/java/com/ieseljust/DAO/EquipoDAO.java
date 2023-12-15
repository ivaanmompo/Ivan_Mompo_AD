
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import com.ieseljust.Model.Equipo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class EquipoDAO {

    Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();

    public EquipoDAO() {

    }

    //insert
    public void insertEquipo(Equipo Equipo) {
        try {
            laSesion.getTransaction().begin();
            laSesion.save(Equipo);
            laSesion.getTransaction().commit();
            System.out.println("Equipo inserted correctly");
        } catch (Exception e) {
            laSesion.getTransaction().rollback();
            System.out.println("Error inserting Equipo. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //delete
    public void deleteEquipo(Equipo Equipo) {
        try {
            laSesion.getTransaction().begin();
            laSesion.delete(Equipo);
            laSesion.getTransaction().commit();
            System.out.println("Equipo deleted corrected");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Equipo. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //update
    public void updateEquipo(int id) {
        try {
            laSesion.getTransaction().begin();

            Equipo Equipotoupdate = laSesion.get(Equipo.class, id);

            Equipotoupdate.setNombre("barcelona");

            laSesion.saveOrUpdate(Equipotoupdate);

            laSesion.getTransaction().commit();

            System.out.println("Equipo updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Equipo. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    public void selectAll() {
        try {
            laSesion.getTransaction().begin();


            laSesion.getTransaction().commit();

            System.out.println("Equipo updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Equipo. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }
}

