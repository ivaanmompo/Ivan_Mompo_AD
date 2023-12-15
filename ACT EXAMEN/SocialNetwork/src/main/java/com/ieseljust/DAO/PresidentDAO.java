
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import com.ieseljust.Model.President;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class PresidentDAO {

    Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();

    public PresidentDAO() {

    }

    //insert
    public void insertPresident(President President) {
        try {
            laSesion.getTransaction().begin();
            laSesion.save(President);
            laSesion.getTransaction().commit();
            System.out.println("President inserted correctly");
        } catch (Exception e) {
            laSesion.getTransaction().rollback();
            System.out.println("Error inserting President. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //delete
    public void deletePresident(President President) {
        try {
            laSesion.getTransaction().begin();
            laSesion.delete(President);
            laSesion.getTransaction().commit();
            System.out.println("President deleted corrected");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting President. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    //update
    public void updatePresident(int id) {
        try {
            laSesion.getTransaction().begin();

            President Presidenttoupdate = laSesion.get(President.class, id);

            Presidenttoupdate.setNombre("laport");

            laSesion.saveOrUpdate(Presidenttoupdate);

            laSesion.getTransaction().commit();

            System.out.println("President updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting President. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    public void selectAll() {
        try {
            laSesion.getTransaction().begin();


            laSesion.getTransaction().commit();

            System.out.println("President updated correctly");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error inserting President. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }
}

