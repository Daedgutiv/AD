package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constantes {
	
	public static String user;
	public static String password;
	public static String conexion;
	public static String driver;
	
	public Constantes(String user, String pass, String con, String driver) throws FileNotFoundException, IOException {
			
		this.user = user;
		this.password = pass;
		this.conexion = con;
		this.driver =driver;
		
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getConexion() {
		return conexion;
	}

	public String getDriver() {
		return driver;
	}
	
	

}
