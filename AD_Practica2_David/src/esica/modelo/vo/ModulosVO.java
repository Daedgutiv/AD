package esica.modelo.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModulosVO {
	
	private ArrayList<ModuloVO> lista;

	@XmlElement
	public ArrayList<ModuloVO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<ModuloVO> lista) {
		this.lista = lista;
	}
	
	

}
