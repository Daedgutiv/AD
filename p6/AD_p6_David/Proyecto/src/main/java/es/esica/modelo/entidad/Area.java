package es.esica.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

public class Area implements Serializable {
	
	private int id;
	private String area;
	private Set<Enunciado> enunciados;
	
	public Area() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Set<Enunciado> getEnunciados() {
		return enunciados;
	}

	public void setEnunciados(Set<Enunciado> enunciados) {
		this.enunciados = enunciados;
	}

	
	
}
