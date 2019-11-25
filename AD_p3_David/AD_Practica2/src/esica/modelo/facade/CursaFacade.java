package esica.modelo.facade;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import esica.modelo.vo.CursaVO;
import esica.modelo.vo.CursanVO;
import esica.modelo.vo.ModulosVO;

public class CursaFacade {
	final static File file = new File("Cursa.xml");

	public static void crearFile() throws JAXBException {
		ArrayList<CursaVO> lista = new ArrayList<CursaVO>();
		escribir(lista);
	}

	public static ArrayList<CursaVO> recuperar() throws JAXBException, IllegalArgumentException {
		JAXBContext context = JAXBContext.newInstance(CursanVO.class);
		CursanVO cursan = new CursanVO();
		ArrayList<CursaVO> listaCursan = new ArrayList<CursaVO>();

		if (!file.exists()) {
			crearFile();
		}

		Unmarshaller um = context.createUnmarshaller();
		cursan = (CursanVO) um.unmarshal(file);
		listaCursan = cursan.getLista();
		if(listaCursan==null) {
			listaCursan = new ArrayList<CursaVO>();
		}
		return listaCursan;
	}

	public static void escribir(ArrayList<CursaVO> cursan) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ModulosVO.class);
		CursanVO cursan2 = new CursanVO();
		cursan2.setLista(cursan);

		Marshaller um = context.createMarshaller();
        um.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
		um.marshal(cursan2, file);
	}

	public static void anhadirCursa(CursaVO cursa) throws JAXBException {
		ArrayList<CursaVO> cursan = recuperar();
		if (cursa.getId()!=null && cursa.getDni()!=null && cursa.getId()>=0) {
			cursan.add(cursa);
		}
		escribir(cursan);
	}

	public static void modificarCursa(CursaVO cursa) throws JAXBException {
		ArrayList<CursaVO> cursan = recuperar();
		for (int i =0; i<cursan.size();i++) {
			if (cursan.get(i).getDni().equalsIgnoreCase(cursa.getDni()) && cursan.get(i).getId()==cursa.getId()) {
				cursan.set(i, cursa);
			}
		}
		escribir(cursan);
	}

	public static void borrarCursa(CursaVO cursa) throws JAXBException {
		ArrayList<CursaVO> cursan = recuperar();
		for (int i =0; i<cursan.size();i++) {
			if (cursan.get(i).getDni().equalsIgnoreCase(cursa.getDni()) && cursan.get(i).getId()==cursa.getId()) {
				cursan.remove(i);
			}
		}
		escribir(cursan);
	}
}
