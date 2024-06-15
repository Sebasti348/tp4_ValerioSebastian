package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.collections.ListadoMaterias;

import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	@GetMapping("/formularioMateria")
	
	public static ModelAndView FormMateria() {
		ModelAndView modelView = new ModelAndView("formMateria");
		return modelView;
		
	}
	
	@PostMapping("/guardarMateria")
	
	public static ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
		//guardar Materia
		ListadoMaterias.agregarMateria(materiaParaGuardar);
		//mostrar el listado
		ModelAndView modelView 	= new ModelAndView("listadoDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMateria());
		
		return modelView;
	}
}
