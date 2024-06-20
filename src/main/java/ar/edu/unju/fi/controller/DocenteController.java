package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Carrera;
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
		modelView.addObject("flag", false);
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
	@GetMapping("/listaDocentes")
	public ModelAndView getFormListaDocentes(){
		//vista listadoDeDocentes.html
		ModelAndView modelView= new  ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		return modelView;
	}
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView deleteCarreraDelListado(@PathVariable (name="legajo") int legajo) {
		
		//borrar
		ListadoDocentes.eliminarDocente(legajo);
		
		//mostrar nueva lista de docentes
		ModelAndView modelView = new ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		
		 return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView getFormModificarDocente(@PathVariable(name="legajo") int legajo) {
		Docente docente = ListadoDocentes.buscarDocentePorLegajo(legajo);
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docente);
		modelView.addObject("flag", true);
		return modelView;
		
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView modificarDocente (@ModelAttribute("nuevoDocente")Docente docenteModificado) {
		ListadoDocentes.modificarDocente(docenteModificado);
		ModelAndView modelView =new ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		return modelView;
	}
	
		
}
