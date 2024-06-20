package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {
	
	public static List<Materia> materias = new ArrayList<Materia>();
	
	//listar Materias
	
	public static List<Materia> listarMateria(){
		
		return materias;
	}
	
	public static Materia buscarMateriaporNombre (String nombre) {
		for(Materia m : materias) {
			if(m.getNombre().equals(nombre)) {
				return m;
			}
			
		}
		return null;
		
	}
	
	public static void agregarMateria (Materia m) {
		//agregar estado
		m.setEstado(true);
		materias.add(m);		
	}
	
	  // Método para modificar una materia
	  public static void modificarMateria(Materia materiaModificada) {
	    for (int i = 0; i < materias.size(); i++) {
	      Materia materia = materias.get(i);
	      if (materia.getNombre().equals(materiaModificada.getNombre())) {
	        materias.set(i, materiaModificada);
	        break;
	      }
	    }
	  }

	  // Método para eliminar una materia
	  public static void eliminarMateria(String nombre) {
		  //borrado físico
	    //cmaterias.removeIf(materia -> materiaa.getNombre().equals(nombre));
		  
		  //borrado lógico
		  for (int i = 0; i < materias.size(); i++) {
		      Materia materia = materias.get(i);
		      if (materia.getNombre().equals(nombre)) {
		        materia.setEstado(false);;
		        break;
		      }
		    }
}
	

}
