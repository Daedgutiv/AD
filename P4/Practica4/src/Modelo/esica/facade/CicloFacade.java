package Modelo.esica.facade;

import java.sql.Connection;
import java.sql.DriverManager;
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
		
		Connection conexion= DriverManager.getConnection(Constantes.conexion,Constantes.user,Constantes.password);
		
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

}
