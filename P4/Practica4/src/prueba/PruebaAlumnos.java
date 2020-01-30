package prueba;

import javax.swing.JOptionPane;

public class PruebaAlumnos {

	public static void main(String[] args) {

		int menu = 1;

		while (menu != 0) {

			menu = Integer.valueOf(JOptionPane.showInputDialog("Seleccione una opción: \n" + "1- Añadir alumno.\n"
					+ "2- Modificar alumno.\n" + "3- Eliminar alumno.\n" + "0- Salir."));

			switch (menu) {
			case 1:
				
				break;
			case 2:

				break;
			case 3:

				break;

			}

		}

	}

}
