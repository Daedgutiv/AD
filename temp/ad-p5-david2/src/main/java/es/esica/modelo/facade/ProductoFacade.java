package es.esica.modelo.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import es.esica.modelo.vo.ProductoVO;

public class ProductoFacade {

	private static SessionFactory factoria = null;

	public static Session getSession() {

		if (factoria == null) {
			Configuration con = new Configuration();
			con.configure();
			factoria = con.buildSessionFactory();
		}

		return factoria.openSession();

	}

	public static List<ProductoVO> recuperar() {

		Session sesion = getSession();

		sesion.beginTransaction();

		Query query = sesion.createQuery("FROM ProductoVO");

		List<ProductoVO> lista = query.list();

		sesion.getTransaction().commit();
		sesion.close();

		return lista;

	}

	public static void anhadirProducto(ProductoVO producto) {

		Session sesion = getSession();

		sesion.beginTransaction();

		sesion.save(producto);

		sesion.getTransaction().commit();
		sesion.close();

	}

	public static void eliminarProductos(ProductoVO producto) {

		Session sesion = getSession();

		sesion.beginTransaction();

		sesion.delete(producto);

		sesion.getTransaction().commit();
		sesion.close();

	}

	public static ProductoVO buscarReferencia(String referencia) {
		ProductoVO producto = new ProductoVO();

		Session sesion = getSession();

		sesion.beginTransaction();

		Query query = sesion.createQuery("FROM ProductoVO WHERE referencia=:ref");
		
		query.setParameter("ref", referencia);

		List<ProductoVO> lista = query.list();

		sesion.getTransaction().commit();
		sesion.close();
		
		if (lista.size()==1) {
			producto=lista.get(0);
		} else {
			producto=null;
		}

		return producto;
	}
}
