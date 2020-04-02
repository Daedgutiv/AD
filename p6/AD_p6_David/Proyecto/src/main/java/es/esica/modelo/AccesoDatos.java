package es.esica.modelo;

import java.io.ObjectInputStream.GetField;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.esica.modelo.entidad.Enunciado;
import es.esica.modelo.entidad.Prueba;
import es.esica.modelo.entidad.Respuesta;
import es.esica.modelo.entidad.Usuario;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class AccesoDatos {
	
	public static void anhadirUsuario(Usuario usuario) {
		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		sesion.save(usuario);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static Set<Prueba> recuperarPruebas() {

		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		Set<Prueba> pruebas = new HashSet<Prueba>(sesion.createQuery("FROM Prueba").list());
		sesion.getTransaction().commit();
		for (Iterator it = pruebas.iterator(); it.hasNext();) {
			Prueba x = (Prueba) it.next();
			Usuario usuario = (Usuario) x.getUsuario();
			Set enunciados = x.getEnunciados();
			for (Iterator it2 = enunciados.iterator(); it2.hasNext();) {
				Enunciado enunciado = (Enunciado) it2.next();
				Set respuestas = enunciado.getRespuestas();
				for(Iterator it3 = respuestas.iterator();it3.hasNext();) {
					Respuesta respuesta = (Respuesta) it3.next();
				}
			}
		}
		sesion.close();

		return pruebas;
	}

	public static void anhadirPrueba(Prueba prueba) {

		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		sesion.save(prueba);
		sesion.getTransaction().commit();
		sesion.close();

	}

	public static void eliminarPrueba(Prueba prueba) {
		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		sesion.delete(prueba);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void modificarPrueba(Prueba prueba) {
		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		sesion.update(prueba);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void anhadirPregunta(Enunciado enunciado) {
		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		sesion.save(enunciado);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static Set<Enunciado> recuperarPreguntas() {
		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		Set<Enunciado> enunciados = new HashSet<Enunciado>(sesion.createQuery("FROM Enunciado").list());
		sesion.getTransaction().commit();
		
		for (Iterator it = enunciados.iterator(); it.hasNext();) {
			Enunciado x = (Enunciado) it.next();
			Set respuestas = x.getRespuestas();
			for (Iterator it2 = respuestas.iterator(); it2.hasNext();) {
				Respuesta respuesta = (Respuesta) it2.next();
			}
		}
		sesion.close();
		return enunciados;
	}

	public static void eliminarPregunta(Enunciado enunciado) {
		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		sesion.delete(enunciado);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void modificarPregunta(Enunciado enunciado) {
		Session sesion = HibernateControler.getSession();
		sesion.beginTransaction();
		sesion.update(enunciado);
		sesion.getTransaction().commit();
		sesion.close();
	}
}
