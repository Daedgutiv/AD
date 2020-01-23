package Modelo.esica.vo;

public class ModuloVO {
	
	
	private int id;

	private String nombre;

	private String curso;

	private int id_ciclo;

	private String horas;
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public int getCiclo() {
		return id_ciclo;
	}
	public void setCiclo(int ciclo) {
		this.id_ciclo = ciclo;
	}
	
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
