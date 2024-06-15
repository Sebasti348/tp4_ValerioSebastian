package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.collections.ListadoDocentes;

import ar.edu.unju.fi.model.Docente;

@Controller

public class DocenteController {
	@Autowired
	Docente nuevoDocente = new Docente();
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formDocente.html
		ModelAndView modelView = new ModelAndView("formDocente");
		//agrega el objeto
		
		modelView.addObject("nuevoDocente", nuevoDocente);
		
		return modelView;
	}
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente( @ModelAttribute("nuevoDocente") Docente docenteParaGuardar) {

		//guardar 
		ListadoDocentes.agregarDocente(docenteParaGuardar);
		//mostrar el listado
		ModelAndView modelView 	= new ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
	
		return modelView;		
	}
	
		
}
