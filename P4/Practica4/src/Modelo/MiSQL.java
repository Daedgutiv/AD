package Modelo;

public class MiSQL {
	
	public static final String insertModulo = "INSERT INTO MODULO (ID, HORAS, NOMBRE, CURSO, ID_CICLO) VALUES (MODULO_SEQ.NEXTVAL,?,?,?,?)";
	public static final String insertAlumno = "INSERT INTO ALUMNO (DNI, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, NACIMIENTO) VALUES (?,?,?,?,?,?)";
	public static final String insertCiclo = "INSERT INTO CICLO (ID, NOMBRE, NIVEL, CURSO) VALUES (CICLO_SEQ.NEXTVAL,?,?,?)";
	public static final String insertCursa = "INSERT INTO CURSA (ANHO, ID_MODULO, DNI, NOTA) VALUES (?,?,?,?)";
	
	public static final String selectAllModulo = "SELECT ID, HORAS, NOMBRE, CURSO, ID_CICLO FROM MODULO";
	public static final String selectAllCiclos = "SELECT ID, NOMBRE, NIVEL, CURSO FROM CICLO";
	public static final String selectAllAlumnos = "SELECT DNI, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, NACIMIENTO FORM ALUMNOS";
	
	public static final String updateModulo = "UPDATE MODULO SET HORAS = ?, NOMBRE = ?, CURSO = ?, ID_CICLO = ? WHERE ID = ?";
	public static final String updateAlumno = "UPDATE ALUMNO SET NOMBRE = ?, APELLIDO1 = ?, APELLIDO2 = ?, TELEFONO = ?, NACIMIENTO = ? WHERE DNI = ?";
	public static final String updateCiclo = "UPDATE CICLO SET NOMBRE = ?, NIVEL = ?, CURSO = ? WHERE ID =?";
	
	public static final String eliminarModulo = "DELETE FROM MODULO WHERE ID = ?";
	public static final String eliminarAlumno = "DELETE FROM ALUMNO WHERE DNI = ?";
	public static final String eliminarCiclo = "DELETE FROM CICLO WHERE ID = ?";

}
