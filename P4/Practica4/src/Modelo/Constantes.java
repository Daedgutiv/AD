package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constantes {
	
	public String user;
	public String password;
	public String conexion;
	public String driver;
	
	public Constantes() throws FileNotFoundException, IOException {
		
		Properties props = new Properties();
		
		props.load(new FileInputStream("conect.props"));
		
		this.user = props.getProperty("user");
		this.password = props.getProperty("password");
		this.conexion = props.getProperty("conexion");
		this.driver = props.getProperty("driver");
		
		System.out.println(this.user + this.driver + this.conexion + this.password);
	}

}
