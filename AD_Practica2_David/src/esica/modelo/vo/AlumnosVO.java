package esica.modelo.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlumnosVO {

	private ArrayList<AlumnoVO> lista;

	@XmlElement
	public ArrayList<AlumnoVO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AlumnoVO> lista) {
		this.lista = lista;
	}

}
