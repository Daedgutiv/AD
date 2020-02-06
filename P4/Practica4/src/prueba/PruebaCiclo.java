package prueba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import Modelo.Constantes;
import Modelo.esica.facade.CicloFacade;
import Modelo.esica.vo.CicloVO;

public class PruebaCiclo {

	protected static void leerProps() throws FileNotFoundException, IOException {
		Properties props = new Properties();

		props.load(new FileInputStream("conect.props"));

		Constantes cons = new Constantes(props.getProperty("user"), props.getProperty("password"),
				props.getProperty("conexion"), props.getProperty("driver"));

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		leerProps();

		int menu = 1;

		while (menu != 0) {

			menu = Integer.valueOf(JOptionPane.showInputDialog("Seleccione una opción: \n" + "1- Añadir ciclo.\n"
					+ "2- Modificar ciclo.\n" + "3- Eliminar ciclo.\n" + "0- Salir."));

			switch (menu) {
			case 1:

				CicloVO ciclo = new CicloVO();
				ciclo.setNombre("Iago");
				ciclo.setNivel("Arriba");
				ciclo.setCurso(3);

				CicloFacade.anhadirCiclo(ciclo);

				break;
			case 2:
				CicloVO ciclo2 = new CicloVO();
				ciclo2.setNombre("DESARROLLO DE APLICACIONES MULTIPLATAFORMA");
				ciclo2.setNivel("SUPERIOR");
				ciclo2.setCurso(2);
				ciclo2.setId(0);

				CicloFacade.modificarCiclo(ciclo2);
				break;
			case 3:

				CicloVO ciclo3 = new CicloVO();
				ciclo3.setId(3);

				CicloFacade.eliminarCiclo(ciclo3);

				break;
			}

		}
	}

}
