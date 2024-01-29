package modelo.entidad;

import java.io.Serializable;
import java.util.Objects;

public class Articulo implements Serializable{
	
	
	private static final long serialVersionUID = 8381489835878358615L;
	
	//Atributos
	private String nombre, descripcion;
	private int id, stock;
	private double precio;
	
	//Constructores
	public Articulo() {
		super();
	}
	
	public Articulo(String nombre, String descripcion, int id, int stock, double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = id;
		this.stock = stock;
		this.precio = precio;
	}
	
	
	//toString()
	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", descripcion=" + descripcion + ", id=" + id + ", stock=" + stock
				+ ", precio=" + precio + "]\n" ;
	}
	
	//Equals y hashCode 
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return id == other.id;
	}
	
	//getters y setters
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
