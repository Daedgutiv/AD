package esica.modelo.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CursanVO {

	@XmlElement
	private ArrayList<CursaVO> lista;

	public ArrayList<CursaVO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CursaVO> lista) {
		this.lista = lista;
	}
	
	
}
