package modelo.negocio;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.entidad.Articulo;

public class Almacen implements IntGestionArticulos , Serializable{

	
	private static final long serialVersionUID = -5785878991659280096L;
	
	private ArrayList<Articulo> listaArticulos;
	
	public Almacen() {
		listaArticulos = new ArrayList<>();
	}
	/**
	 * Metodo que permite dar de alta un nuevo objeto de tipo Articulo en el ArrayList,
	 * asignándole un id único.
	 *  
	 * @param articulo el objeto de tipo Articulo a dar de alta
	 * @return el artículo dado de alta en caso de que esta se haya producido, null en caso contrario
	 */
	
	@Override
	public Articulo altaArticulo(Articulo articulo) {
		int id = 1;
		
		//Comprobamos si el arraylist está vacío, si es así añadimos el artículo
		if (listaArticulos.isEmpty()) {
			articulo.setId(id);
			listaArticulos.add(articulo);
			return articulo;
		} else {
			//Si el arraylist está vacío, lo recorremos
			for (Articulo a: listaArticulos) {
				/*Comprobamos si existe algún artículo en el arraylist con el mismo nombre y descripción, 
				 *ya que en tal caso, consideramos que es el mismo que estamos introduciendo
				 * 
				 */
				if(articulo.getNombre().equalsIgnoreCase(a.getNombre())&& articulo.getDescripcion().equalsIgnoreCase(a.getDescripcion())) {
					return null;
				}
				while(a.getId() == id) {
					id++;
				}
			}
			//Asignamos el id al artículo a añadir
			articulo.setId(id);
			listaArticulos.add(articulo);
			return articulo;
			}
		}
	
	/**
	 * Método que permite borrar un objeto de tipo Articulo del arraylist, 
	 * por medio de su id
	 *  
	 * @param id el id del articulo a eliminar del Arraylist
	 * @return <b>true</b> en caso de que se haya borrado, <b>false</b> 
	 * en caso contrario
	 */
	@Override
	public Boolean borrarArticulo(int id) {
		Articulo a = new Articulo();
		a.setId(id);
		int posicion = listaArticulos.indexOf(a);
		if(posicion == -1) {
			return false;
		} else {
			listaArticulos.remove(posicion);
			return true;
		}
	}
	/**
	 * Método que permite buscar un objeto de tipo Articulo en el arraylist, 
	 * por medio de su id
	 *  
	 * @param id el id del articulo a buscar en el Arraylist
	 * @return el articulo que se quería buscar, null en caso de que no exista
	 * en el arraylist
	 */
	@Override
	public Articulo buscarArticulo(int id) {
		
		Articulo a = new Articulo();
		a.setId(id);
		int posicion = listaArticulos.indexOf(a);
		
		if(posicion == -1) {
			return null;
		} else {
			return listaArticulos.get(posicion);
		}
		
	}
	/**
	 * Método que permite mostrar todos los objetos de tipo articulo que contiene
	 * el arraylist
	 *  
	 * @return el arraylist que contiene los articulos
	 */
	@Override
	public ArrayList<Articulo> buscarTodos() {
		return listaArticulos;
	}

}
