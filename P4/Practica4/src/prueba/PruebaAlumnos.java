package prueba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import Modelo.Constantes;
import Modelo.esica.facade.AlumnoFacade;
import Modelo.esica.vo.AlumnoVO;

public class PruebaAlumnos {

	protected static void leerProps() throws FileNotFoundException, IOException {
		Properties props = new Properties();

		props.load(new FileInputStream("conect.props"));

		Constantes cons = new Constantes(props.getProperty("user"), props.getProperty("password"),
				props.getProperty("conexion"), props.getProperty("driver"));

	}

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		leerProps();

		int menu = 1;

		while (menu != 0) {

			menu = Integer.valueOf(JOptionPane.showInputDialog("Seleccione una opción: \n" + "1- Añadir alumno.\n"
					+ "2- Modificar alumno.\n" + "3- Eliminar alumno.\n" + "0- Salir."));

			switch (menu) {
			case 1:
				String nombre = JOptionPane.showInputDialog("Nombre");
				String apellido1 = JOptionPane.showInputDialog("apellido1");
				String apellido2 = JOptionPane.showInputDialog("apellido 2");
				String dni = JOptionPane.showInputDialog("dni");
				Date nacimiento = Date.valueOf(JOptionPane.showInputDialog("nacimiento YYYY-MM-DD"));
				String telefono = JOptionPane.showInputDialog("tel");

				AlumnoVO alumno = new AlumnoVO();

				alumno.setApellido1(apellido1);
				alumno.setApellido2(apellido2);
				alumno.setNombre(nombre);
				alumno.setTelefono(telefono);
				alumno.setNacimiento(nacimiento);
				alumno.setDni(dni);

				AlumnoFacade.anhadirAlumno(alumno);

				break;
			case 2:
				String nombre2 = JOptionPane.showInputDialog("Nombre");
				String apellido12 = JOptionPane.showInputDialog("apellido1");
				String apellido22 = JOptionPane.showInputDialog("apellido 2");
				String dni2 = JOptionPane.showInputDialog("dni");
				Date nacimiento2 = Date.valueOf(JOptionPane.showInputDialog("nacimiento YYYY-MM-DD"));
				String telefono2 = JOptionPane.showInputDialog("tel");

				AlumnoVO alumno2 = new AlumnoVO();

				alumno2.setApellido1(apellido12);
				alumno2.setApellido2(apellido22);
				alumno2.setNombre(nombre2);
				alumno2.setTelefono(telefono2);
				alumno2.setNacimiento(nacimiento2);
				alumno2.setDni(dni2);
				
				AlumnoFacade.modificarAlumno(alumno2);
				
				break;
			case 3:
				
				String dni3 = JOptionPane.showInputDialog("dni");
				
				AlumnoVO alumno3 = new AlumnoVO();
				alumno3.setDni(dni3);
				
				AlumnoFacade.eliminarAlumno(alumno3);
				
				break;

			}

		}

	}

}
