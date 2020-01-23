package Controlador.esica.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import Modelo.Constantes;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ModulosController mc = new ModulosController();
		mc.show();
	}

}
