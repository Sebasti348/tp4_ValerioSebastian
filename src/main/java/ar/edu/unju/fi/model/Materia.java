package ar.edu.unju.fi.model;

public class Materia {
	private String nombre;
	private String curso;
	private int cant_hs;
	private String modalidad;
	private Docente docente;
	private Carrera carrera;
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(String nombre, String curso, int cant_hs, String modalidad, Docente docente, Carrera carrera) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.cant_hs = cant_hs;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
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

	public int getCant_hs() {
		return cant_hs;
	}

	public void setCant_hs(int cant_hs) {
		this.cant_hs = cant_hs;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", curso=" + curso + ", cant_hs=" + cant_hs + ", modalidad=" + modalidad
				+ ", docente=" + docente + ", carrera=" + carrera + "]";
	}
	
	
	
}
