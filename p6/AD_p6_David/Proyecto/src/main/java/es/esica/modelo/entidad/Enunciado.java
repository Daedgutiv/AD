package es.esica.modelo.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Enunciado implements Serializable{
	
	private int id;
	private String enunciado;
	private Set<Prueba> pruebas= new HashSet<Prueba>();
	private Set<Respuesta> respuestas = new HashSet<Respuesta>();
	private Set<Tag> tags = new HashSet<Tag>();
	private Area area;
	
	public Enunciado() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Set<Prueba> getPruebas() {
		return pruebas;
	}

	public void setPruebas(Set<Prueba> pruebas) {
		this.pruebas = pruebas;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	

}
