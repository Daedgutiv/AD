package es.esica.controlador;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

import es.esica.modelo.facade.ProductoFacade;
import es.esica.modelo.vo.ProductoVO;
import es.esica.vista.VistaProducto;

public class Controlador extends VistaProducto {

	public void anhadir() {
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
			if (split.length > 1) {
				if (String.valueOf(precio).length() > 7) {
					JOptionPane.showMessageDialog(null, "El precio es demasiado alto, 4 dígitos máx.",
							"Error de formato", JOptionPane.ERROR_MESSAGE);
					precio = new BigDecimal(-1);
				} else if (split[1].length() > 2) {
					JOptionPane.showMessageDialog(null, "El precio tiene demasiados decimales", "Error de formato",
							JOptionPane.ERROR_MESSAGE);
					precio = new BigDecimal(-1);
				}
			} else {
				if (Integer.valueOf(String.valueOf(precio))>9999) {
					JOptionPane.showMessageDialog(null, "El precio es demasiado alto, 4 dígitos máx.",
							"Error de formato", JOptionPane.ERROR_MESSAGE);
					precio = new BigDecimal(-1);
				}
			}

		}

		ProductoFacade.anhadirProducto(new ProductoVO(0, nombre, referencia, descripcion, cantidad, precio));
	}

	public void borrar() {

		Integer pos = -1;
		while (pos == -1) {
			try {
				pos = Integer.valueOf(JOptionPane.showInputDialog(null, listaFormateada(ProductoFacade.recuperar())));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debes introducir el número del producto", "Error de formato",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		ProductoFacade.eliminarProductos(ProductoFacade.recuperar().get(pos - 1));

	}

	public String listaFormateada(List<ProductoVO> lista) {

		String aux = "Productos(" + lista.size() + "):\n";

		for (int i = 0; i < lista.size(); i++) {
			aux = aux + (i + 1) + ". " + lista.get(i).toString() + "\n";
		}

		return aux;
	}

	public void mostrar() {

		JOptionPane.showMessageDialog(null, listaFormateada(ProductoFacade.recuperar()), "Lista de producto", JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void exportarXML() {
		try {
			ProductoFacade.exportarXML();
		} catch (JAXBException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al intentar exportar la lista de Productos", "Error al exportar",
					JOptionPane.ERROR_MESSAGE);
		}

			

	}

	@Override
	public void importarXML() {
		
		String ruta = JOptionPane.showInputDialog("Introduzca la ruta del archivo a importar");
		
		try {
			ProductoFacade.importarXML(ruta);
		} catch (JAXBException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al importar, no se ha podido acabar la operación", "Error al importar", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException exc) {
			JOptionPane.showMessageDialog(null, "La ruta expecificada no existe", "Error al importar", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void buscarReferencia() {

		String referencia = JOptionPane.showInputDialog("Introduzca la referencia");
		
		mostrarReferencia(referencia);
		
	}

	@Override
	public void mostrarReferencia(String referencia) {
		
		JOptionPane.showMessageDialog(null, listaFormateada(ProductoFacade.buscarReferencia(referencia).getLista()), "Lista de producto", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
