package Controlador.esica.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.esica.facade.CicloFacade;
import Modelo.esica.facade.ModuloFacade;
import Modelo.esica.vo.CicloVO;
import Modelo.esica.vo.ModuloVO;
import Vista.esica.views.ModulosUI;

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
			
			if (getNombre().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Nombre está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else if (getCurso().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Curso está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else if (getHoras().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Horas está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else if (getCicloId()==null) {
				JOptionPane.showMessageDialog(null, "El campo Ciclo está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (!isNumber(getCurso()) || !isNumber(getHoras())) {
			JOptionPane.showMessageDialog(null, "Curso o horas no son números", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			modulo.setNombre(getNombre());
			modulo.setCurso(Integer.valueOf(getCurso()));
			modulo.setHoras(Integer.valueOf(getHoras()));
			modulo.setCiclo(getCicloId());

			try {
				ModuloFacade.anhadirModulo(modulo);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void editarModulo() {
		ModuloVO modulo = new ModuloVO();

		if (getNombre().isEmpty() || getCurso().isEmpty() || getHoras().isEmpty() || getCicloId() == null) {
			if (getNombre().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Nombre está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else if (getCurso().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Curso está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else if (getHoras().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Horas está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else if (getCicloId()==null) {
				JOptionPane.showMessageDialog(null, "El campo Ciclo está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} else if (!isNumber(getCurso()) || !isNumber(getHoras())) {
			JOptionPane.showMessageDialog(null, "Curso o horas no son números", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			modulo.setNombre(getNombre());
			modulo.setCurso(Integer.valueOf(getCurso()));
			modulo.setHoras(Integer.valueOf(getHoras()));
			modulo.setId(getId());
			modulo.setCiclo(getCicloId());

			try {
				ModuloFacade.modificarModulo(modulo);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void eliminarModulo() {
		ModuloVO modulo = new ModuloVO();
		modulo.setId(getId());
		try {
			ModuloFacade.eliminarModulo(modulo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected List<String[]> transformarListaVO() {
		ArrayList<String[]> lista = new ArrayList<String[]>();
		ArrayList<ModuloVO> modulos = null;
		try {
			modulos = ModuloFacade.recuperar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < modulos.size(); i++) {
			String[] array = { modulos.get(i).getNombre(), String.valueOf(modulos.get(i).getCiclo()),
					String.valueOf(modulos.get(i).getCurso()), String.valueOf(modulos.get(i).getHoras()),
					String.valueOf(modulos.get(i).getId()) };
			lista.add(array);
		}

		return lista;
	}

	@Override
	protected void cargarComboCiclos() {
		ArrayList<CicloVO> lista = null;
		try {
			lista = CicloFacade.leerCiclos();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < lista.size(); i++) {
			addCiclo(i + 1, lista.get(i).getNombre());
		}
		
	}

	
	
}
