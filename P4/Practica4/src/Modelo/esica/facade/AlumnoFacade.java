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
import Modelo.esica.vo.AlumnoVO;

public class AlumnoFacade {

	protected static Connection conexionSQL() throws ClassNotFoundException, SQLException {

		Class.forName(Constantes.driver);

		Connection conexion = DriverManager.getConnection(Constantes.conexion, Constantes.user, Constantes.password);

		return conexion;
	}

	public static ArrayList<AlumnoVO> leerAlumnos() throws ClassNotFoundException, SQLException {

		Connection con = conexionSQL();

		ArrayList<AlumnoVO> lista = new ArrayList<AlumnoVO>();

		Statement s = con.createStatement();

		ResultSet result = s.executeQuery(MiSQL.selectAllAlumnos);

		while (result.next()) {
			AlumnoVO aux = new AlumnoVO();

			aux.setNombre(result.getString("NOMBRE"));
			aux.setApellido1(result.getString("APELLIDO1"));
			aux.setApellido2(result.getString("APELLIDO2"));
			aux.setTelefono(result.getString("TELEFONO"));
			aux.setNacimiento(result.getDate("NACIMIENTO"));

			lista.add(aux);
		}

		s.close();
		con.close();

		return lista;
	}

	public static void modificarAlumno(AlumnoVO alumno) throws ClassNotFoundException, SQLException {

		Connection con = conexionSQL();

		PreparedStatement ps = con.prepareStatement(MiSQL.updateAlumno);

		ps.setString(1, alumno.getNombre());
		ps.setString(2, alumno.getApellido1());
		ps.setString(3, alumno.getApellido2());
		ps.setString(4, alumno.getTelefono());
		ps.setDate(5, alumno.getNacimiento());
		ps.setString(6, alumno.getDni());

		ps.executeUpdate();

		ps.close();
		con.close();

	}

	public static void eliminarAlumno(AlumnoVO alumno) throws ClassNotFoundException, SQLException {

		Connection con = conexionSQL();

		PreparedStatement ps = con.prepareStatement(MiSQL.eliminarAlumno);

		ps.setString(1, alumno.getDni());

	}
	
	public static void anhadirAlumno(AlumnoVO alumno) throws ClassNotFoundException, SQLException {
		
		Connection con = conexionSQL();
		
		PreparedStatement ps = con.prepareStatement(MiSQL.insertAlumno);
		
		ps.setString(1, alumno.getDni());
		ps.setString(2, alumno.getNombre());
		ps.setString(3, alumno.getApellido1());
		ps.setString(4, alumno.getApellido2());
		ps.setString(5, alumno.getTelefono());
		ps.setDate(6, alumno.getNacimiento());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	}

}
