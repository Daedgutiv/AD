package Modelo.esica.vo;

public class ModuloVO {
	
	
	private int id;

	private String nombre;

	private int curso;

	private int id_ciclo;

	private int horas;
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	public int getCiclo() {
		return id_ciclo;
	}
	public void setCiclo(int ciclo) {
		this.id_ciclo = ciclo;
	}
	
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
