package es.esica.modelo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoVO implements Serializable{

	
	private Integer id;
	private String nombre;
	private String referencia;
	private String descripcion;
	private Integer cantidad;
	private BigDecimal precio;

	public ProductoVO() {
		
	}
	
	public ProductoVO(Integer id, String nombre, String referencia, String descripcion, Integer cantidad, BigDecimal precio) {
		this.id = id;
		this.nombre= nombre;
		this.descripcion=descripcion;
		this.referencia=referencia;
		this.cantidad= cantidad;
		this.precio=precio;
	}

	/**
	 * @return el valor de id
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
	 * @return el valor de nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre a asignar a nombre 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el valor de referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia a asignar a referencia 
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return el valor de descripcion
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
	 * @return el valor de cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad a asignar a cantidad 
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return el valor de precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * @param precio a asignar a precio 
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	
}
