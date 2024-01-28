package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Articulos implements Serializable{

		private int id;
		private String nombre, descripcion;
		private int stock;
		private double precio;
		
		private static List<Articulos> listaArticulos = new ArrayList<>();

		//Constructor
		public Articulos(int id, String nombre, String descripcion, int stock, double precio) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.stock = stock;
			this.precio = precio;
			
		}
		
		//Getter and setters 

		public Articulos() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public int getStock() {
			return stock;
		}


		public void setStock(int stock) {
			this.stock = stock;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}



		public static List<Articulos> getListaArticulos() {
			return listaArticulos;
		}


		public void setListaArticulos(List<Articulos> listaArticulos) {
			this.listaArticulos = listaArticulos;
		}
		
		//Metodo toString
		@Override
		public String toString() {
			return "Articulos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
					+ ", precio=" + precio + "]";
		}

		//Cargar datos
	    public static void cargarDatos() {
	        listaArticulos = new ArrayList<>();
	        listaArticulos.add(new Articulos(1, "Martillo", "Martillo de carpintero", 50, 15.99));
	        listaArticulos.add(new Articulos(2, "Destornillador", "Destornillador Phillips", 100, 5.49));
	        listaArticulos.add(new Articulos(3, "Sierra", "Sierra para madera", 30, 12.79));
	        listaArticulos.add(new Articulos(4, "Cinta métrica", "Cinta métrica de acero", 80, 8.99));
	        listaArticulos.add(new Articulos(5, "Llave inglesa", "Llave ajustable", 60, 9.99));
	        listaArticulos.add(new Articulos(6, "Clavo", "Clavo de acero", 200, 0.05));
	        listaArticulos.add(new Articulos(7, "Tornillo", "Tornillo de cabeza hexagonal", 150, 0.08));
	        listaArticulos.add(new Articulos(8, "Pala", "Pala de jardinería", 40, 18.99));
	        listaArticulos.add(new Articulos(9, "Alicate", "Alicate de punta", 70, 7.49));
	        listaArticulos.add(new Articulos(10, "Brocha", "Brocha de pintor", 90, 4.99));
	        listaArticulos.add(new Articulos(11, "Llave de tubo", "Llave de tubo ajustable", 55, 11.29));
	        listaArticulos.add(new Articulos(12, "Cepillo metálico", "Cepillo de alambre", 120, 3.49));
	        listaArticulos.add(new Articulos(13, "Alambre", "Alambre galvanizado", 180, 2.99));
	        listaArticulos.add(new Articulos(14, "Nivel", "Nivel de burbuja", 25, 14.49));
	        listaArticulos.add(new Articulos(15, "Cerrojo", "Cerrojo de seguridad", 35, 6.99));
	        listaArticulos.add(new Articulos(16, "Taladro", "Taladro eléctrico", 20, 49.99));
	        listaArticulos.add(new Articulos(17, "Grifo", "Grifo de agua", 75, 27.99));
	        listaArticulos.add(new Articulos(18, "Candado", "Candado de seguridad", 85, 8.49));
	        listaArticulos.add(new Articulos(19, "Pegamento", "Pegamento multiusos", 65, 3.99));
	        listaArticulos.add(new Articulos(20, "Escalera", "Escalera de aluminio", 15, 39.99));
	    }

	//Añadir Articulo 
	  public  boolean añadirArticulo(Articulos articulo) {	
		  
		if (listaArticulos.contains(articulo))
			return false;
		else 
			return listaArticulos.add(articulo);
	  }
	  
	  //Borrar Articulo
	  public boolean borrarArticulo(Articulos articulo) {
		  return listaArticulos.remove(articulo);  
	  }
	  
	  //Consultar Articulo por id
	  public Articulos consultarArticuloId(int id) {
		    for (Articulos a : listaArticulos) { //recorremos el array para buscar el mismo id
		        if (a.getId() == id) {
		            return a;
		        }
		    }
		    return null;
		}
	  //Listamos todos los articulos
	  public static  List<Articulos> listadoArticulos() {
		  return listaArticulos;
	  }

	
}
