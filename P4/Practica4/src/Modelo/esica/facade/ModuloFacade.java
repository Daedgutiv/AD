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
import Modelo.esica.vo.ModuloVO;

public class ModuloFacade {

	protected static Connection conexionSQL() throws ClassNotFoundException, SQLException {

		Class.forName(Constantes.driver);

		Connection conexion = DriverManager.getConnection(Constantes.conexion, Constantes.user, Constantes.password);

		return conexion;
	}

	public static boolean comprobarModulo(ModuloVO modulo) {
		if (modulo.getHoras() > 999 || modulo.getHoras() <= 0) {
			JOptionPane.showMessageDialog(null, "El campo Horas no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (modulo.getNombre().trim().isEmpty() || modulo.getNombre().length() > 60) {
			JOptionPane.showMessageDialog(null, "El campo Nombre está vacío o excede la longitud máximo", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (modulo.getCurso() > 9 || modulo.getCurso() <= 0) {
			JOptionPane.showMessageDialog(null, "El campo Curso no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (modulo.getCiclo() <= 0 || modulo.getCiclo() > 9) {
			JOptionPane.showMessageDialog(null, "El campo Ciclo no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static void anhadirModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {

		if (comprobarModulo(modulo)) {

			Connection con = conexionSQL();

			PreparedStatement ps = con.prepareStatement(MiSQL.insertModulo);

			ps.setInt(1, modulo.getHoras());
			ps.setString(2, modulo.getNombre());
			ps.setInt(3, modulo.getCurso());
			ps.setInt(4, modulo.getCiclo());

			ps.executeUpdate();

			ps.close();
			con.close();
		}

	}

	public static void modificarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {
		
		if (comprobarModulo(modulo)) {
			Connection con = conexionSQL();

			PreparedStatement ps = con.prepareStatement(MiSQL.updateModulo);

			ps.setInt(1, modulo.getHoras());
			ps.setString(2, modulo.getNombre());
			ps.setInt(3, modulo.getCurso());
			ps.setInt(4, modulo.getCiclo());
			ps.setInt(5, modulo.getId());

			ps.executeUpdate();

			ps.close();
			con.close();
		}

		
	}

	public static void eliminarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {

		Connection con = conexionSQL();

		PreparedStatement ps = con.prepareStatement(MiSQL.eliminarModulo);

		ps.setInt(1, modulo.getId());

		ps.executeUpdate();

		ps.close();
		con.close();

	}

	public static ArrayList<ModuloVO> recuperar() throws SQLException, ClassNotFoundException {

		Connection con = conexionSQL();

		Statement s = con.createStatement();

		ResultSet result = s.executeQuery(MiSQL.selectAllModulo);

		ArrayList<ModuloVO> lista = new ArrayList<ModuloVO>();

		while (result.next()) {
			ModuloVO aux = new ModuloVO();

			aux.setId(result.getInt("ID"));
			aux.setCiclo(result.getInt("ID_CICLO"));
			aux.setCurso(result.getInt("CURSO"));
			aux.setHoras(result.getInt("HORAS"));
			aux.setNombre(result.getString("NOMBRE"));

			lista.add(aux);

		}

		s.close();
		con.close();

		return lista;

	}

}
