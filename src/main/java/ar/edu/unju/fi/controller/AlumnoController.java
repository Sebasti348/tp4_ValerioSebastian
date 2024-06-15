package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;


@Controller
public class AlumnoController {
	@Autowired	  
	Alumno nuevoAlumno = new Alumno();

	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formAlumno.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		//agrega el objeto
		
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		
		return modelView;
	}
	

	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno( @ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {

		//guardar
		ListadoAlumnos.agregarAlumno(alumnoParaGuardar);
		//mostrar el listado
		ModelAndView modelView 	= new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
	
		return modelView;		
	}
	
	@GetMapping("/eliminarAlumno/{lu}")
	public ModelAndView deleteAlumnoDelListado(@PathVariable (name="codigo") int libretau) {
		
		//borrar
		ListadoAlumnos.eliminarAlumno(libretau);
		
		//mostrar nueva lista de alumnos
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnos());
		
		 return modelView;
	}
	

}