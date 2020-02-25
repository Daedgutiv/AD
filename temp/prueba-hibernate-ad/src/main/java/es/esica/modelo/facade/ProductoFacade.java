package es.esica.modelo.facade;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import es.esica.modelo.vo.ProductoVO;

public class ProductoFacade {

	private static SessionFactory factoria=null;

	public static Session getSession() {

		if (factoria == null) {
			Configuration con = new Configuration();
			con.configure();
			factoria = con.buildSessionFactory();
		}

		return factoria.openSession();

	}
	
	public List<ProductoVO> recuperar(){
		
		Session sesion = getSession();
		
		sesion.beginTransaction();
		
		Query query = sesion.createQuery("findAllProductos");
		
		List<ProductoVO> lista = query.list();
		
		sesion.getTransaction().commit();
		sesion.close();
		
		return lista;
		
	}

}
