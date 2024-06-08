package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	@Autowired
	Docente nuevoDocente = new Docente();
	@GetMapping("/formularioDocente")
	public ModelAndView getFormCarrera() {
		//vista formDocente.html
		ModelAndView modelView = new ModelAndView("formDocente");
		//agrega el objeto
		
		modelView.addObject("nuevoDocente", nuevoDocente);
		
		return modelView;
	}
		
}
