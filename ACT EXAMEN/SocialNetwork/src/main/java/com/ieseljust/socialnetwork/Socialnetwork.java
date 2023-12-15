package com.ieseljust.socialnetwork;

import com.ieseljust.DAO.EquipoDAO;
import com.ieseljust.DAO.JugadorsDAO;
import com.ieseljust.DAO.PosicionDAO;
import com.ieseljust.DAO.PresidentDAO;
import com.ieseljust.ORM.HibernateUtil;
import com.ieseljust.Model.Equipo;
import com.ieseljust.Model.Jugador;
import com.ieseljust.Model.Posicion;
import com.ieseljust.Model.President;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class Socialnetwork {

    public static void main(String[] args) {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
//        SessionFactory sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Users.class).buildSessionFactory();
//        Session laSesion = sessionFactory.getCurrentSession();
        
        Transaction transaction = laSesion.beginTransaction();
        Equipo eq1 = new Equipo("Barcelona");
        laSesion.save(eq1);
        Jugador j1 = new Jugador("messi", "DL");
        laSesion.save(j1);
        Posicion p1 = new Posicion( "DL");
        Posicion p2 = new Posicion("MC");
        laSesion.save(p1);
        laSesion.save(p2);
        President pre1 = new President("laporte");
        laSesion.save(pre1);
        laSesion.getTransaction().commit();
/**
        //insert
        EquipoDAO dao = new EquipoDAO();
        Equipo eq1 = new Equipo("Barcelona");
        Equipo eq2 = new Equipo();
        eq2.setNombre("Madrid");
        dao.insertEquipo(eq1);

        //delete
        
        Equipo eq3 = new Equipo();
        eq3.setId(1);
        dao.deleteEquipo(eq3);

        
        //update

        dao.updateEquipo(1);
        dao.selectAll();

        **/
        
    }
}
