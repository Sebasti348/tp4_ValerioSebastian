package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> docentes = new ArrayList<Docente>();
	 //Metodo para listar Docentes
	
		public static List<Docente> listarDocentes(){
			return docentes;
		}
		
		
		//Metodo para buscar docente por legajo

		public static Docente buscarDocentePorLegajo (int legajo) {
			
			for(Docente d : docentes) {
				if(d.getLegajo() == legajo) {
				return d;
					}
				}
				return null;
		}
				
		
			  // Método para agregar una docente
			  public static void agregarDocente(Docente d) {
				  d.setEstado(true);
			    docentes.add(d);
			  }

			  // Método para modificar una docente
			  public static void modificarDocente(Docente docenteModificado) {
			    for (int i = 0; i < docentes.size(); i++) {
			      Docente docente = docentes.get(i);
			      if (docente.getLegajo() == (docenteModificado.getLegajo())) {
			        docentes.set(i, docenteModificado);
			        break;
			      }
			    }
			  }

			  // Método para eliminar una docente
			  public static void eliminarDocente(int legajo) {
				  //borrado físico
			    //docente.removeIf(legajo -> docente.getLegajo()== legajo);
				  
				  //borrado lógico
				  for (int i = 0; i < docentes.size(); i++) {
				      Docente docente = docentes.get(i);
				      if (docente.getLegajo()==legajo) {
				        docente.setEstado(false);;
				        break;
				      }
				    }
			  

				
		}

}
