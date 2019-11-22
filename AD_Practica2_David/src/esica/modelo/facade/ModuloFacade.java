package esica.modelo.facade;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import esica.modelo.vo.ModuloVO;
import esica.modelo.vo.ModulosVO;

public class ModuloFacade {
	final static File file = new File("Modulos.xml");

	public static void crearFile() throws JAXBException {
		ArrayList<ModuloVO> lista = new ArrayList<ModuloVO>();
		escribir(lista);
	}

	public static ArrayList<ModuloVO> recuperar() throws JAXBException, IllegalArgumentException {
		JAXBContext context = JAXBContext.newInstance(ModulosVO.class);
		ModulosVO modulos = new ModulosVO();
		ArrayList<ModuloVO> listaModulos = new ArrayList<ModuloVO>();

		if (!file.exists()) {
			crearFile();
		}

		Unmarshaller um = context.createUnmarshaller();
		modulos = (ModulosVO) um.unmarshal(file);
		listaModulos = modulos.getLista();
		if (listaModulos==null) {
			listaModulos=new ArrayList<ModuloVO>();
		}
		return listaModulos;
	}

	public static void escribir(ArrayList<ModuloVO> modulos) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ModulosVO.class);
		ModulosVO modulos2 = new ModulosVO();
		modulos2.setLista(modulos);

		Marshaller um = context.createMarshaller();
        um.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
		um.marshal(modulos2, file);
	}

	public static void anhadirModulo(ModuloVO modulo) throws JAXBException {
		ArrayList<ModuloVO> modulos = recuperar();
		if (modulos.size() == 0) {
			modulo.setId(0);
		} else {
			modulo.setId(modulos.get(modulos.size() - 1).getId() + 1);
		}
		modulos.add(modulo);
		escribir(modulos);
	}

	public static void modificarModulo(ModuloVO modulo) throws JAXBException {
		ArrayList<ModuloVO> modulos = recuperar();
		for (int i = 0; i < modulos.size(); i++) {
			if (modulos.get(i).getId() == modulo.getId()) {
				modulos.set(i, modulo);
			}
		}
		escribir(modulos);
	}

	public static void borrarModulo(int id) throws JAXBException {
		ArrayList<ModuloVO> modulos = recuperar();
		modulos.remove(id);
		escribir(modulos);
	}
}
