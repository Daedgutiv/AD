package es.esica.demo;

import java.util.Date;

import org.hibernate.Session;

import es.esica.modelo.facade.HibernateFacade;
import es.esica.modelo.vo.EventoVO;

public class Demo {

	public static void main(String[] args) {
		
		EventoVO evento = new EventoVO(100, "pablo deja de ponerme  minas", new Date());
		
		Session ses = HibernateFacade.getSession();
		
		ses.beginTransaction();
		
		ses.delete(evento);
		
		
		
		ses.getTransaction().commit();
		ses.close();

	}

}
