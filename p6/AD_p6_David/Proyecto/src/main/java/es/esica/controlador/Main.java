package es.esica.controlador;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import es.esica.modelo.AccesoDatos;
import es.esica.modelo.entidad.Enunciado;
import es.esica.modelo.entidad.Prueba;
import es.esica.modelo.entidad.Respuesta;
import es.esica.modelo.entidad.Usuario;

public class Main {

	public static void main(String[] args) {
		enunciado();
		pruebas();
		eliminarPrueba();
	}

	private static void enunciado() {
		Respuesta respuesta = new Respuesta();
		respuesta.setCorrecta(true);
		respuesta.setRespuesta("Esta es la respuesta correcta");
		Enunciado enunciado = new Enunciado();
		enunciado.setEnunciado("Cual es la respuesta correcta?");
		Set<Respuesta> respuestas = new HashSet<Respuesta>();
		respuestas.add(respuesta);
		enunciado.setRespuestas(respuestas);
		respuesta.setEnunciado(enunciado);

		AccesoDatos.anhadirPregunta(enunciado);
	}

	private static void verPreguntas() {
		Set<Enunciado> enunciados = AccesoDatos.recuperarPreguntas();

		for (Iterator it = enunciados.iterator(); it.hasNext();) {
			Enunciado x = (Enunciado) it.next();
			System.out.println(x.getEnunciado());
			Set respuestas = x.getRespuestas();
			for (Iterator it2 = respuestas.iterator(); it2.hasNext();) {
				Respuesta respuesta = (Respuesta) it2.next();
				System.out.println("Respuesta: " + respuesta.getRespuesta());
			}
		}
	}

	private static void modificarPregunta() {
		Respuesta respuesta = new Respuesta();
		respuesta.setCorrecta(true);
		respuesta.setRespuesta("Esta es la respuesta correcta");
		Enunciado enunciado = new Enunciado();
		enunciado.setEnunciado("Cual es la respuesta correcta?");
		Set<Respuesta> respuestas = new HashSet<Respuesta>();
		respuestas.add(respuesta);
		respuesta.setRespuesta("Segunda respuesta");
		respuesta.setCorrecta(false);
		respuestas.add(respuesta);
		enunciado.setRespuestas(respuestas);
		respuesta.setEnunciado(enunciado);
		enunciado.setId(1);

		AccesoDatos.modificarPregunta(enunciado);
	}

	private static void eliminarPregunta() {
		Respuesta respuesta = new Respuesta();
		respuesta.setCorrecta(true);
		respuesta.setRespuesta("Esta es la respuesta correcta");
		Enunciado enunciado = new Enunciado();
		enunciado.setEnunciado("Cual es la respuesta correcta?");
		Set<Respuesta> respuestas = new HashSet<Respuesta>();
		respuestas.add(respuesta);
		respuesta.setRespuesta("Segunda respuesta");
		respuesta.setCorrecta(false);
		respuestas.add(respuesta);
		enunciado.setRespuestas(respuestas);
		respuesta.setEnunciado(enunciado);
		enunciado.setId(2);

		AccesoDatos.eliminarPregunta(enunciado);
	}

	private static void verPruebas() {

		Set pruebas = AccesoDatos.recuperarPruebas();

		for (Iterator it = pruebas.iterator(); it.hasNext();) {
			Prueba x = (Prueba) it.next();
			System.out.println("Id prueba: " + x.getId() + "; Usuario de la prueba: " + x.getUsuario().getDni());
			Set enunciados = x.getEnunciados();
			for (Iterator it2 = enunciados.iterator(); it2.hasNext();) {
				Enunciado enunciado = (Enunciado) it2.next();
				System.out.println(enunciado.getEnunciado());
				Set respuestas = enunciado.getRespuestas();
				for (Iterator it3 = respuestas.iterator(); it3.hasNext();) {
					Respuesta respuesta = (Respuesta) it3.next();
					System.out.println(respuesta.getRespuesta());
				}
			}
		}
	}

	private static void pruebas() {
		Prueba prueba = new Prueba();

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		prueba.setFecha(date);

		Usuario usuario = new Usuario();
		usuario.setDni("53197452Q");
		usuario.setClave("kuhaku");
		prueba.setUsuario(usuario);

		prueba.setEnunciados(AccesoDatos.recuperarPreguntas());

		AccesoDatos.anhadirPrueba(prueba);

	}

	private static void usuario() {
		Usuario usuario = new Usuario();
		usuario.setDni("53197452Q");
		usuario.setClave("kuhaku");
		AccesoDatos.anhadirUsuario(usuario);

	}

	private static void eliminarPrueba() {

		Prueba prueba = new Prueba();

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		prueba.setFecha(date);

		Usuario usuario = new Usuario();
		usuario.setDni("53197452Q");
		usuario.setClave("kuhaku");
		prueba.setUsuario(usuario);

		prueba.setEnunciados(AccesoDatos.recuperarPreguntas());

		prueba.setId(1);

		AccesoDatos.eliminarPrueba(prueba);
	}
	
	private static void modificarPrueba() {
		
		Prueba prueba = new Prueba();

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		prueba.setFecha(date);

		Usuario usuario = new Usuario();
		usuario.setDni("53197452Q");
		usuario.setClave("kuhaku");
		prueba.setUsuario(usuario);
		prueba.setIncorrectas(5);

		prueba.setEnunciados(AccesoDatos.recuperarPreguntas());
		
		prueba.setId(1);
		
		AccesoDatos.modificarPrueba(prueba);
	}

}
