package es.esica.modelo.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductosVO {
	
	private List<ProductoVO> lista;
	
	public ProductosVO(List<ProductoVO> list) {
		
		this.lista=list;
		
	}
	
	public ProductosVO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return el valor de lista
	 */
	@XmlElement
	public List<ProductoVO> getLista() {
		return lista;
	}

	/**
	 * @param lista a asignar a lista to set
	 */
	public void setLista(List<ProductoVO> lista) {
		this.lista = lista;
	}
	


}
