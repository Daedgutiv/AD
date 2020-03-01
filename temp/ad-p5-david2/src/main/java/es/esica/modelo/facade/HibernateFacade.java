package es.esica.modelo.facade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFacade {
	
	private static SessionFactory factoria;
	
	public static Session getSession() {
		
		if(factoria==null) {
			Configuration con = new Configuration();
			con.configure();
			factoria= con.buildSessionFactory();
		}
		
		return factoria.openSession();
	}

}
