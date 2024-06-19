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
import ar.edu.unju.fi.collections.ListadoMaterias;

import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formMateria");
		//agrega el objeto
		  	
		modelView.addObject("nuevaMateria", nuevaMateria);
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("flag",false);
		return modelView;
	}
	@GetMapping("/listadoMaterias")
	public ModelAndView getListaMaterias() {
		ModelAndView modelView = new ModelAndView("listadoDeMaterias");
		
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMateria());
		return modelView;
	}
	 
	@PostMapping("/guardarMateria")
	
	public static ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
		//guardar Materia
		materiaParaGuardar.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaParaGuardar.getDocente().getLegajo()));
		materiaParaGuardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaParaGuardar.getCarrera().getCodigo()));
		ListadoMaterias.agregarMateria(materiaParaGuardar);
		//mostrar el listado
		ModelAndView modelView 	= new ModelAndView("listadoDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMateria());
		
		return modelView;
	}
	@GetMapping("/eliminarMateria/{nombre}")
	public ModelAndView deleteCarreraDelListado(@PathVariable (name="nombre") String nombre) {
		
		//borrar
		ListadoMaterias.eliminarMateria(nombre);
		
		//mostrar nueva lista de materias
		ModelAndView modelView = new ModelAndView("listadoDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMaterias.listarMateria());
		
		 return modelView;
	}
	
	@GetMapping("/modificarMateria/{nombre}")
	public ModelAndView getFormModificarMateria(@PathVariable(name="nombre") String nombre) {
		Materia materia = ListadoMaterias.buscarMateriaporNombre(nombre);
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materia);
		modelView.addObject("flag", true);
		return modelView;
		
	}
	
	@PostMapping("/modificarMateriaa")
	public ModelAndView modifcarMateria (@ModelAttribute("nuevaMateria")Materia materiaModificada) {
		ListadoMaterias.modificarMateria(materiaModificada);
		ModelAndView modelView =new ModelAndView("listadoDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMateria());
		return modelView;
	}
}
