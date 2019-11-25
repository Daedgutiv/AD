package esica.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import esica.modelo.facade.ModuloFacade;
import esica.modelo.vo.ModuloVO;
import esica.modelo.vo.ModulosVO;
import esica.vista.*;

public class ModulosController extends ModulosUI {

	protected boolean isNumber(String texto) {

		try {
			Integer.valueOf(texto);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	protected void agregarModulo() {
		ModuloVO modulo = new ModuloVO();

		if (getNombre().isEmpty() || getCurso().isEmpty() || getHoras().isEmpty() || getCicloId() == null) {
			System.out.println("Algún campo está vacío");
		} else if (!isNumber(getCurso()) || !isNumber(getHoras())) {
			System.out.println("Curso o horas no son números");
		} else {
			modulo.setNombre(getNombre());
			modulo.setCurso(getCurso());
			modulo.setHoras(getHoras());
			modulo.setCiclo(getCicloId());

			try {
				ModuloFacade.anhadirModulo(modulo);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void editarModulo() {
		ModuloVO modulo = new ModuloVO();

		if (getNombre().isEmpty() || getCurso().isEmpty() || getHoras().isEmpty() || getCicloId() == null) {
			System.out.println("Algún campo está vacío");
		} else if (!isNumber(getCurso()) || !isNumber(getHoras())) {
			System.out.println("Curso o horas no son números");
		} else {
			modulo.setNombre(getNombre());
			modulo.setCurso(getCurso());
			modulo.setHoras(getHoras());
			modulo.setId(getId());
			modulo.setCiclo(getCicloId());

			try {
				ModuloFacade.modificarModulo(modulo);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void eliminarModulo() {
		try {
			ModuloVO modulo = new ModuloVO();
			modulo.setId(getId());
			ModuloFacade.borrarModulo(modulo);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected List<String[]> transformarListaVO() {
		ArrayList<String[]> lista = new ArrayList<String[]>();
		ArrayList<ModuloVO> modulos = null;
		try {
			modulos = ModuloFacade.recuperar();
		} catch (Exception e) { 
			
		}
		for (int i = 0; i < modulos.size(); i++) {
			String[] array = { modulos.get(i).getNombre(), String.valueOf(modulos.get(i).getCiclo()),
					String.valueOf(modulos.get(i).getCurso()), String.valueOf(modulos.get(i).getHoras()),
					String.valueOf(modulos.get(i).getId()) };
			lista.add(array);
		}

		return lista;
	}

}
