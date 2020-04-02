package es.esica.modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateControler {
	
	public static SessionFactory factoria= null;
	
	public static Session getSession() {

		if (factoria == null) {
			Configuration con = new Configuration();
			con.configure();
			factoria = con.buildSessionFactory();
		}

		return factoria.openSession();

	}

}
