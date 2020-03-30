package es.esica.modelo.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class Prueba implements Serializable{

	private int id;
	private Float nota;
	private int incorrectas;
	private int noRespondidas;
	private int correctas;
	private float tiempo;
	private Date fecha;
	private Usuario usuario;
	private Set<Enunciado> enunciados;
	
	public Prueba() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public int getIncorrectas() {
		return incorrectas;
	}

	public void setIncorrectas(int incorrectas) {
		this.incorrectas = incorrectas;
	}

	public int getNoRespondidas() {
		return noRespondidas;
	}

	public void setNoRespondidas(int noRespondidas) {
		this.noRespondidas = noRespondidas;
	}

	public int getCorrectas() {
		return correctas;
	}

	public void setCorrectas(int correctas) {
		this.correctas = correctas;
	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Enunciado> getEnunciados() {
		return enunciados;
	}

	public void setEnunciados(Set<Enunciado> enunciados) {
		this.enunciados = enunciados;
	}
	
	
	
	
}
