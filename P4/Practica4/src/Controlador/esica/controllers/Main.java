package Controlador.esica.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import Modelo.Constantes;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		leerProps();
		ModulosController mc = new ModulosController();
		mc.show();
	}

	protected static void leerProps() throws FileNotFoundException, IOException {
		Properties props = new Properties();

		props.load(new FileInputStream("conect.props"));
		
		Constantes cons = new Constantes(props.getProperty("user"),props.getProperty("password"), props.getProperty("conexion"), props.getProperty("driver"));
		
	}

}
