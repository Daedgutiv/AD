package es.esica.vista;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;
import es.esica.modelo.facade.ProductoFacade;
import es.esica.modelo.vo.ProductoVO;

public class VistaProducto {

	public static void menu() {
		String o = "0";

		while (!o.equalsIgnoreCase("7")) {
			o = JOptionPane.showInputDialog(
					"Seleccione una opción:\n1. Alta producto.\n2. Baja Producto.\n3. Obtener producto por referencia.\n4.Listar productos.\n5. Importar productos.\n6. Exportar productos.\n7. Salir.");

			switch (Integer.parseInt(o)) {

			case 1:
				anhadir();
				break;
			case 2:
				borrar();
				break;
			case 3:

				break;
			case 4:
				mostrar();
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:
				Boolean salir = salir();
				if (salir==false) {
					o="0";
				}
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

	private static void anhadir() {
		String nombre = "";

		while (nombre.isEmpty()) {
			nombre = JOptionPane.showInputDialog("Nombre del producto:");
			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo nombre es obligatorio", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
			} else if (nombre.trim().length() > 50) {
				JOptionPane.showMessageDialog(null, "Nombre demasiado largo, Máximo 50 carácteres.", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
				nombre = "";
			}
		}

		String descripcion = "";

		while (descripcion.isEmpty()) {
			descripcion = JOptionPane.showInputDialog("Descripción del producto:");

			if (descripcion.length() > 200) {
				JOptionPane.showMessageDialog(null, "Descripción demasiado larga", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
				descripcion = "";
			}

		}

		String referencia = "";

		while (referencia.isEmpty()) {
			referencia = JOptionPane.showInputDialog("Referencia del producto:");
			if (referencia.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo referencia es obligatorio", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
			} else if (referencia.trim().length() > 10) {
				JOptionPane.showMessageDialog(null, "Referencia demasiado larga, Máximo 10 carácteres.",
						"Error de formato", JOptionPane.ERROR_MESSAGE);
				referencia = "";
			}
		}

		Integer cantidad = -1;

		while (cantidad == -1) {
			try {
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del producto:"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error la cantidad debe ser un número entero", "Error de formato",
						JOptionPane.ERROR_MESSAGE, null);
			}

			if (String.valueOf(cantidad).length() > 4) {
				JOptionPane.showMessageDialog(null, "Cantidad demasiado grande, Máximo 4 dígitos.", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
				cantidad = -1;
			}
		}

		BigDecimal precio = new BigDecimal(-1);

		while (precio.equals(new BigDecimal(-1))) {
			try {
				precio = new BigDecimal(JOptionPane.showInputDialog("Precio del producto:"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error el precio debe ser un número", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
			}

			String[] split = String.valueOf(precio).split("\\.");

			if (String.valueOf(precio).length() > 7) {
				JOptionPane.showMessageDialog(null, "El precio es demasiado alto, 4 dígitos máx.", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
				precio = new BigDecimal(-1);
			} else if (split[1].length() > 2) {
				JOptionPane.showMessageDialog(null, "El precio tiene demasiados decimales", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
				precio = new BigDecimal(-1);
			}

		}

		ProductoFacade.anhadirProducto(new ProductoVO(0, nombre, referencia, descripcion, cantidad, precio));
	}

	private static void borrar() {

		Integer pos = -1;
		while (pos == -1) {
			try {
				pos = Integer.valueOf(JOptionPane.showInputDialog(null, listaFormateada()));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debes introducir el número del producto", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		ProductoFacade.eliminarProductos(ProductoFacade.recuperar().get(pos - 1));

	}

	private static void mostrar() {

		JOptionPane.showMessageDialog(null, listaFormateada(), "Lista de producto", JOptionPane.INFORMATION_MESSAGE);

	}

	private static String listaFormateada() {

		List<ProductoVO> lista = ProductoFacade.recuperar();
		String aux = "Productos(" + lista.size() + "):\n";

		for (int i = 0; i < lista.size(); i++) {
			aux = aux + (i + 1) + ". " + lista.get(i).toString() + "\n";
		}

		return aux;
	}

}
