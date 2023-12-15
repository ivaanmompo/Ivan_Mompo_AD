
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import com.ieseljust.Model.Posicion;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class PosicionDAO {

    Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();

    public PosicionDAO() {

    }

    //insert
    public void insertPosicion(Posicion Posicion) {
        try {
            laSesion.getTransaction().begin();
            laSesion.save(Posicion);
            laSesion.getTransaction().commit();
            System.out.println("Posicion inserted correctly");
        } catch (Exception e) {
            laSesion.getTransaction().rollback();
            System.out.println("Error inserting Posicion. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //delete
    public void deletePosicion(Posicion Posicion) {
        try {
            laSesion.getTransaction().begin();
            laSesion.delete(Posicion);
            laSesion.getTransaction().commit();
            System.out.println("Posicion deleted corrected");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Posicion. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //update
    public void updatePosicion(int id) {
        try {
            laSesion.getTransaction().begin();

            Posicion Posiciontoupdate = laSesion.get(Posicion.class, id);

            Posiciontoupdate.setNombre("DEL");

            laSesion.saveOrUpdate(Posiciontoupdate);

            laSesion.getTransaction().commit();

            System.out.println("Posicion updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Posicion. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    public void selectAll() {
        try {
            laSesion.getTransaction().begin();


            laSesion.getTransaction().commit();

            System.out.println("Posicion updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting Posicion. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }
}

