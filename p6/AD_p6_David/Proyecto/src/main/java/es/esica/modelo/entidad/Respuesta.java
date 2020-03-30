package es.esica.modelo.entidad;

import java.io.Serializable;

public class Respuesta implements Serializable{
	
	private int id;
	private String respuesta;
	private boolean correcta;
	private Enunciado enunciado;
	
	public Respuesta() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public boolean isCorrecta() {
		return correcta;
	}

	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}

	public Enunciado getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(Enunciado enunciado) {
		this.enunciado = enunciado;
	}
	
	

}
