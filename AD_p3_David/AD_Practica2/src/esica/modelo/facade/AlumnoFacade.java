package esica.modelo.facade;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import esica.modelo.vo.AlumnoVO;
import esica.modelo.vo.AlumnosVO;
import esica.modelo.vo.ModulosVO;

public class AlumnoFacade {
	final static File file = new File("Alumnos.xml");

	public static void crearFile() throws JAXBException {
		ArrayList<AlumnoVO> lista = new ArrayList<AlumnoVO>();
		escribir(lista);
	}

	public static ArrayList<AlumnoVO> recuperar() throws JAXBException, IllegalArgumentException {
		JAXBContext context = JAXBContext.newInstance(ModulosVO.class);
		AlumnosVO alumnos = new AlumnosVO();
		ArrayList<AlumnoVO> listaAlumnos = new ArrayList<AlumnoVO>();

		if (!file.exists()) {
			crearFile();
		}

		Unmarshaller um = context.createUnmarshaller();
		alumnos = (AlumnosVO) um.unmarshal(file);
		listaAlumnos = alumnos.getLista();
		if(listaAlumnos==null) {
			listaAlumnos = new ArrayList<AlumnoVO>();
		}
		return listaAlumnos;
	}

	public static void escribir(ArrayList<AlumnoVO> alumnos) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(AlumnosVO.class);
		AlumnosVO alumnos2 = new AlumnosVO();
		alumnos2.setLista(alumnos);

		Marshaller um = context.createMarshaller();
        um.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
		um.marshal(alumnos2, file);
	}

	public static void anhadirAlumno(AlumnoVO alumno) throws JAXBException {
		ArrayList<AlumnoVO> alumnos = recuperar();
		if (alumno.getDni()!= null) {
			alumnos.add(alumno);
		}
		escribir(alumnos);
	}

	public static void modificarAlumno(AlumnoVO alumno) throws JAXBException {
		ArrayList<AlumnoVO> alumnos = recuperar();
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni() == alumno.getDni()) {
				alumnos.set(i, alumno);
			}
		}
		escribir(alumnos);
	}

	public static void borrarAlumno(AlumnoVO alumno) throws JAXBException {
		ArrayList<AlumnoVO> alumnos = recuperar();
		for(int i=0;i<alumnos.size();i++) {
			if (alumnos.get(i).getDni().equalsIgnoreCase(alumno.getDni())) {
				alumnos.remove(i);
			}
		}
		escribir(alumnos);
	}
}
