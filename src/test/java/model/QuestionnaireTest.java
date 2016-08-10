package model;

import java.util.List;

import org.hibernate.Session;

import common.HibernateUtil;
import junit.framework.TestCase;

/**
 * test class for the model Questionnaire.
 * 
 * @author nicolas malservet
 *
 */
public class QuestionnaireTest extends TestCase {

	/**
	 * method to test adding a model into the db. Open a session thean a
	 * transaction with hibernate. add an object then commit the transaction.
	 */
	public void testAddQuestionnaire() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Questionnaire emp = new Questionnaire();
		emp.setName("user");
		session.save(emp);
		assertTrue(emp.getId() > 0);
		session.getTransaction().commit();
	}

	/**
	 * method to test if the list of questionnaires is not empty.
	 */
	public void testListQuestionnaire() {
		Session session = HibernateUtil.getSession();
		List<Questionnaire> qs = (List<Questionnaire>) session.createQuery("from Questionnaire").getResultList();
		assertTrue(qs.size() > 0);
	}
}
