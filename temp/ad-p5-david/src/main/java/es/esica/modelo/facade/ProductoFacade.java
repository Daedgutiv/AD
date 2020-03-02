package es.esica.modelo.facade;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import es.esica.modelo.vo.ProductoVO;
import es.esica.modelo.vo.ProductosVO;

public class ProductoFacade {

	private final static String RUTA ="ProductosXML.xml";
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

	public static ProductosVO buscarReferencia(String referencia) {
		
		ProductosVO producto = new ProductosVO();

		Session sesion = getSession();

		sesion.beginTransaction();

		Query query = sesion.createQuery("FROM ProductoVO WHERE referencia=:ref");
		
		query.setParameter("ref", referencia);

		List<ProductoVO> lista = query.list();

		sesion.getTransaction().commit();
		sesion.close();
		
		producto.setLista(lista);

		return producto;
	}
	
	public static void exportarXML() throws JAXBException {
		
		ProductosVO productos =  new ProductosVO(recuperar());	
		
		JAXBContext c = JAXBContext.newInstance(ProductosVO.class);
			Marshaller m = c.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(productos, new File(RUTA));
			
	}
	
	public static void importarXML(String ruta) throws JAXBException, IllegalArgumentException {
		
		JAXBContext c = JAXBContext.newInstance(ProductosVO.class);
		Unmarshaller um = c.createUnmarshaller();
		ProductosVO productos = (ProductosVO) um.unmarshal(new File(ruta));
		
		for (int i = 0;i<productos.getLista().size();i++) {
			anhadirProducto(productos.getLista().get(i));
		}
		
	}
}
