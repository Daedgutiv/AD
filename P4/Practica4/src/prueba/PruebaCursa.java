package prueba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import Modelo.Constantes;
import Modelo.esica.facade.CursaFacade;
import Modelo.esica.vo.CursaVO;

public class PruebaCursa {

	protected static void leerProps() throws FileNotFoundException, IOException {
		Properties props = new Properties();

		props.load(new FileInputStream("conect.props"));

		Constantes cons = new Constantes(props.getProperty("user"), props.getProperty("password"),
				props.getProperty("conexion"), props.getProperty("driver"));

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		leerProps();

		int menu = 1;

		while (menu != 0) {

			menu = Integer.valueOf(JOptionPane.showInputDialog("Seleccione una opción: \n" + "1- Añadir Cursa.\n"
					+ "2- Modificar Cursa.\n" + "3- Eliminar Cursa.\n" + "0- Salir."));
			
			switch (menu) {
			case 1:
				CursaVO cursa = new CursaVO();
				
				cursa.setDni("22751693R");
				cursa.setId(38);
				cursa.setNota(10);
				cursa.setAnho(2018);
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			}
		}

	}

}
