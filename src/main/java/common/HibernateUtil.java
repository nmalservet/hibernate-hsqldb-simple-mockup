package common;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Questionnaire;


/**
 * wrapper to start hibernate
 * @author nicolas malservet
 *
 */
public class HibernateUtil {

private static final SessionFactory sessionFactory;

    static {
        try {

            sessionFactory = new Configuration().configure()
            		//addPackage("com.xyz") //add package if used.
	                   .addAnnotatedClass(Questionnaire.class).buildSessionFactory();
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
}
