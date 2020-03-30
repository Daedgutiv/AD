package es.esica.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {


	private static SessionFactory factoria = null;
	
	public static void main(String[] args) {
		
		getSession();

	}
	
	public static Session getSession() {

		if (factoria == null) {
			Configuration con = new Configuration();
			con.configure();
			factoria = con.buildSessionFactory();
		}

		return factoria.openSession();

	}

}
