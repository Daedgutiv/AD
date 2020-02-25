package es.esica.controlador;

import java.math.BigDecimal;

import org.hibernate.Session;

import es.esica.modelo.facade.ProductoFacade;
import es.esica.modelo.vo.ProductoVO;

public class Main {

	public static void main(String[] args) {

		BigDecimal bd = new BigDecimal(4.5);

		ProductoVO evento = new ProductoVO((Integer) 0, "asd", "asd", "asd", (Integer) 4, bd);
		Session ses = ProductoFacade.getSession();

		ses.beginTransaction();

		ses.save(evento);

		ses.getTransaction().commit();
		ses.close();
	}

}
