package es.esica.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

public class Tag implements Serializable{

	private int id;
	private String nombre;
	private Set<Enunciado> enunciados;
	
	public Tag() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Enunciado> getEnunciados() {
		return enunciados;
	}

	public void setEnunciados(Set<Enunciado> enunciados) {
		this.enunciados = enunciados;
	}
	
	
	
}
