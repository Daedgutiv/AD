package es.esica.vista;

import java.util.List;

import javax.swing.JOptionPane;

import es.esica.modelo.vo.ProductoVO;

public abstract class VistaProducto {
	
	private boolean isNum(String num) {
		
		try {
			Integer.valueOf(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}

	public void menu() {
		String o = "0";

		while (!o.equalsIgnoreCase("7")) {
			do {
				o = JOptionPane.showInputDialog(
					"Seleccione una opción:\n1. Alta producto.\n2. Baja Producto.\n3. Obtener producto por referencia.\n4.Listar productos.\n5. Importar productos.\n6. Exportar productos.\n7. Salir.");
				if (!isNum(o)) {
					JOptionPane.showMessageDialog(null, "Tiene que introducir el número de la opción");
				}
			} while(!isNum(o));
			
			switch (Integer.parseInt(o)) {

			case 1:
				anhadir();
				break;
			case 2:
				borrar();
				break;
			case 3:
				buscarReferencia();
				break;
			case 4:
				mostrar();
				break;
			case 5:
				importarXML();
				break;
			case 6:
				exportarXML();
				break;
			case 7:
				Boolean salir = salir();
				if (salir==false) {
					o="0";
				}
				break;
				default:
					JOptionPane.showMessageDialog(null, "No es una opción");
					break;

			}
		}
	}

	

	private static boolean salir() {
		String aux = "";
		while (!aux.equalsIgnoreCase("S") && !aux.equalsIgnoreCase("N")) {
			aux = JOptionPane.showInputDialog(null, "Seguro que desea salir?(S/N)");
			
			if (aux.equalsIgnoreCase("S")) {
				return true;
			} else if (aux.equalsIgnoreCase("N")) {
				return false;
			}
			
		}

		return false;
	}
	
	public abstract void buscarReferencia();
	
	public abstract void importarXML();
	
	public abstract void exportarXML();
	
	public abstract void anhadir();

	public abstract void borrar();

	public abstract void mostrar();
	
	public abstract void mostrarReferencia(String referencia);

	public abstract String listaFormateada(List<ProductoVO> lista);

}
