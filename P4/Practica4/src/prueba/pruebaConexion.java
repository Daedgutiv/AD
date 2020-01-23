package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pruebaConexion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conexion= DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.224:1521:xe","esik","kuhaku");
		
		Statement s = conexion.createStatement();
		
		ResultSet miRes = s.executeQuery("SELECT * FROM ALUMNO");
		
		
		
		miRes.close();
		s.close();
		conexion.close();

	}

}
