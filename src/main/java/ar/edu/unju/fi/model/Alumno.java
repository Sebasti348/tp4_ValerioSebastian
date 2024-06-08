package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Alumno {
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private LocalDate fec_nac;
	private String domicilio;
	private int lu;
	
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}


	public Alumno(String nombre, String apellido, String email, int telefono, LocalDate fec_nac, String domicilio,
			int lu) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fec_nac = fec_nac;
		this.domicilio = domicilio;
		this.lu = lu;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public LocalDate getFec_nac() {
		return fec_nac;
	}


	public void setFec_nac(LocalDate fec_nac) {
		this.fec_nac = fec_nac;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public int getLu() {
		return lu;
	}


	public void setLu(int lu) {
		this.lu = lu;
	}


	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono
				+ ", fec_nac=" + fec_nac + ", domicilio=" + domicilio + ", lu=" + lu + "]";
	}
	
	
	
}
