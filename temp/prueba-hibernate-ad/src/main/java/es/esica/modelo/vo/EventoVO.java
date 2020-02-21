package es.esica.modelo.vo;

import java.io.Serializable;
import java.util.Date;

public class EventoVO implements Serializable{
	
	private Integer id;
	private	String descripcion;
	private Date fecha;
	
	
	
	public EventoVO(Integer id, String descripcion, Date fecha) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public EventoVO() {
		super();
	}

	/**
	 * @return El valor de id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id a asignar a id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return El valor de descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion a asignar a descripcion 
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return El valor de fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha a asignar a fecha 
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
}
