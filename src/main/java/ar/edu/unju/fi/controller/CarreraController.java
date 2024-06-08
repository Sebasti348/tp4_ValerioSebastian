package ar.edu.unju.fi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;


@Controller
@RequestMapping("/carrera")
public class CarreraController {
	@Autowired
	Carrera nuevaCarrera = new Carrera();

	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formCarrera");
		//agrega el objeto
		
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		
		return modelView;
	}

	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera( @ModelAttribute("nuevaCarrera") Carrera carreraParaGuardar) {

		//guardar
		ListadoCarreras.agregarCarrera(carreraParaGuardar);
		//mostrar el listado
		ModelAndView modelView 	= new ModelAndView("listadoDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
	
		return modelView;		
	}
	
	@GetMapping("/eliminarCarrera/{codigo}")
	public ModelAndView deleteCarreraDelListado(@PathVariable (name="codigo") String codigo) {
		
		//borrar
		ListadoCarreras.eliminarCarrera(codigo);
		
		//mostrar nueva lista de carreras
		ModelAndView modelView = new ModelAndView("listadoDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		 return modelView;
	}
	

}