package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;


public class ListadoAlumnos {
	public static List<Alumno> alumnos =  new ArrayList<Alumno>();
	
	//Metodo para listar Alumnos
	
		public static List<Alumno> listarAlumnos(){
			return alumnos;
		}
		
		
		//Metodo para buscar alumno por lu

		public static Alumno buscarAlumnoPorLu (int libretau) {
			for(Alumno a : alumnos) {
				if(a.getLu()== libretau) {
				return a;
					}
				}
				return null;
		}
				
		
			  // Método para agregar un alumno
			  public static void agregarAlumno(Alumno a) {
				//agregando el estado
				a.setEstado(true);
			    alumnos.add(a);
			  }

			  // Método para modificar un alumno
			  public static void modificarAlumno(Alumno alumnoModificado) {
			    for (int i = 0; i < alumnos.size(); i++) {
			      Alumno alumno = alumnos.get(i);
			      if (alumno.getLu()==(alumnoModificado.getLu())) {
			        alumnos.set(i, alumnoModificado);
			        break;
			      }
			    }  
			  }

			  // Método para eliminar un alumno
			  public static void eliminarAlumno(int libretau) {
				  //borrado físico
			    alumnos.removeIf(alumno -> alumno.getLu()==libretau);
				  
				  //borrado lógico
					/*
					 * for (int i = 0; i < alumnos.size(); i++) { Alumno alumno = alumnos.get(i); if
					 * (alumno.getLu()==libretau) { alumno.setEstado(false);; break; } }
					 */

		}

}
