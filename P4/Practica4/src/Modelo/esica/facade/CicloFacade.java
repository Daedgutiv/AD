package Modelo.esica.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Constantes;
import Modelo.MiSQL;
import Modelo.esica.vo.CicloVO;

public class CicloFacade {

	protected static Connection conexionSQL() throws ClassNotFoundException, SQLException {

		Class.forName(Constantes.driver);

		Connection conexion = DriverManager.getConnection(Constantes.conexion, Constantes.user, Constantes.password);

		return conexion;
	}

	public static ArrayList<CicloVO> leerCiclos() throws ClassNotFoundException, SQLException {

		ArrayList<CicloVO> lista = new ArrayList<CicloVO>();

		Connection con = conexionSQL();

		Statement s = con.createStatement();

		ResultSet result = s.executeQuery(MiSQL.selectAllCiclos);

		while (result.next()) {
			CicloVO aux = new CicloVO();
			aux.setId(result.getInt("ID"));
			aux.setNivel(result.getString("NIVEL"));
			aux.setCurso(result.getInt("CURSO"));
			aux.setNombre(result.getString("NOMBRE"));

			lista.add(aux);
		}

		s.close();
		con.close();

		return lista;
	}

	public static void anhadirCiclo(CicloVO ciclo) throws ClassNotFoundException, SQLException {

		Connection con = conexionSQL();

		PreparedStatement ps = con.prepareStatement(MiSQL.insertCiclo);

		ps.setString(1, ciclo.getNombre());
		ps.setString(2, ciclo.getNivel());
		ps.setInt(3, ciclo.getCurso());

		ps.executeUpdate();

		ps.close();
		con.close();

	}

	public static void modificarCiclo(CicloVO ciclo) throws ClassNotFoundException, SQLException {

		Connection con = conexionSQL();

		PreparedStatement ps = con.prepareStatement(MiSQL.updateCiclo);
		
		ps.setString(1, ciclo.getNombre());
		ps.setString(2, ciclo.getNivel());
		ps.setInt(3, ciclo.getCurso());
		ps.setInt(4, ciclo.getId());
		
		ps.executeUpdate();
		
		ps.close();
		
		con.close();
		
	}
	
	public static void eliminarCiclo (CicloVO ciclo) throws ClassNotFoundException, SQLException {
		Connection con = conexionSQL();
		
		PreparedStatement ps = con.prepareStatement(MiSQL.eliminarCiclo);
		
		ps.setInt(1, ciclo.getId());
		
		ps.executeUpdate();
		
		ps.close();
		
		con.close();
	}

}
