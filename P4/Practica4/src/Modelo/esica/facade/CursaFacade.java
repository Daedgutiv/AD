package Modelo.esica.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Constantes;
import Modelo.MiSQL;
import Modelo.esica.vo.CursaVO;

public class CursaFacade {
	protected static Connection conexionSQL() throws ClassNotFoundException, SQLException {

		Class.forName(Constantes.driver);

		Connection conexion = DriverManager.getConnection(Constantes.conexion, Constantes.user, Constantes.password);

		return conexion;
	}

	public static boolean isNum(String a) {
		try {
			Integer.valueOf(a);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean comprobar(CursaVO a) {

		if (a.getAnho().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Año está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (a.getAnho().trim().length() > 4) {
			JOptionPane.showMessageDialog(null, "El campo Año es demasiado largo", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (a.getDni().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo DNI está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (a.getDni().trim().length() > 9) {
			JOptionPane.showMessageDialog(null, "El campo DNI es demasiado largo", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (a.getDni().trim().length() < 9) {
			JOptionPane.showMessageDialog(null, "El campo DNI es demasiado corto", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (isNum(String.valueOf(a.getId()))) {
			JOptionPane.showMessageDialog(null, "El campo Id Módulo no es un número", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public static ArrayList<CursaVO> recuperar() throws ClassNotFoundException, SQLException {

		Connection con = conexionSQL();

		Statement s = con.createStatement();

		ResultSet result = s.executeQuery(MiSQL.selectAllCursan);

		ArrayList<CursaVO> lista = new ArrayList<CursaVO>();

		while (result.next()) {
			CursaVO aux = new CursaVO();

			aux.setAnho(result.getString("ANHO"));
			aux.setDni(result.getString("DNI"));
			aux.setId(result.getInt("ID_MODULO"));
			aux.setNota(result.getFloat("NOTA"));

			lista.add(aux);
		}

		s.close();
		con.close();

		return lista;

	}

	public static void anhadirCursa(CursaVO cursa) throws ClassNotFoundException, SQLException {

		if (comprobar(cursa)) {
			Connection con = conexionSQL();

			PreparedStatement ps = con.prepareStatement(MiSQL.insertCursa);

			ps.setString(1, cursa.getAnho());
			ps.setInt(2, cursa.getId());
			ps.setString(3, cursa.getDni());
			ps.setFloat(4, cursa.getNota());

			ps.executeUpdate();

			ps.close();
			con.close();
		}

	}

	public static void modificarCursa(CursaVO cursa) throws ClassNotFoundException, SQLException {
		
		if (comprobar(cursa)) {

			Connection con = conexionSQL();

			PreparedStatement ps = con.prepareStatement(MiSQL.updateCursa);

			ps.setString(1, cursa.getAnho());
			ps.setFloat(2, cursa.getNota());
			ps.setString(3, cursa.getDni());
			ps.setInt(4, cursa.getId());

			ps.executeUpdate();

			ps.close();
			con.close();
		}


	}

	public static void eliminarCursa(CursaVO cursa) throws SQLException, ClassNotFoundException {

		Connection con = conexionSQL();

		PreparedStatement ps = con.prepareStatement(MiSQL.eliminarcursa);

		ps.setString(1, cursa.getDni());
		ps.setInt(2, cursa.getId());

		ps.executeUpdate();

		ps.close();
		con.close();

	}

}
