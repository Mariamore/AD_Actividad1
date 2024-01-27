package modelo.negocio;

import java.util.ArrayList;

import modelo.entidad.Articulo;

public interface IntGestionArticulos {
	Articulo altaArticulo(Articulo articulo);
	Boolean borrarArticulo(int id);
	Articulo buscarArticulo(int id);
	ArrayList<Articulo> buscarTodos();
}
