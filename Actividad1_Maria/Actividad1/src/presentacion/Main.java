package presentacion;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.entidad.Articulo;
import modelo.negocio.Almacen;


public class Main {
	
	public static void main(String[] args) {
		
		Almacen almacen = new Almacen();
		
		Scanner sc = new Scanner(System.in);
		
		File fn = new File("articulos.dat");
		
		//Si el fichero ya existe, lo lee
		if (fn.exists()) {
			
			try(FileInputStream fis = new FileInputStream(fn);
					ObjectInputStream ois = new ObjectInputStream(fis);){
				almacen = (Almacen) ois.readObject();
				System.out.println("Lista de artículos leída...");
				
			} catch (IOException e) {
				
				System.out.println("Error al abrir el fichero");
				e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		int opcion = cargarMenu();
		
		while(opcion != 6) {
		switch(opcion) {
		case 1:
			Articulo a = pedirDatosArticulo();
			Articulo a1 = almacen.altaArticulo(a);
			if (a1==null)
				System.out.println("El artículo " + a + " ya se encuentra almacenado.");
			else 
				System.out.println("Artículo añadido.");
			break;
		case 2:
			System.out.println("Introduzca el id del artículo a eliminar:");
			int id = sc.nextInt();
			boolean borrado = almacen.borrarArticulo(id);
			if (borrado)
				System.out.println("Artículo con id " + id + " borrado.");
			else
				System.out.println("El artículo no se ha podido borrar");
			break;
		case 3:
			System.out.println("Introduce el id del artículo a consultar:");
			int id1 = sc.nextInt();
			Articulo a2 = almacen.buscarArticulo(id1);
			if (a2 == null)
				System.out.println("No se ha encontrado el artículo con id " + id1);
			else
				System.out.println("Artículo consultado: " + a2);
			break;
		case 4:
			System.out.println(almacen.buscarTodos());			
			break;
		case 5:
			try(FileOutputStream fichero = new FileOutputStream("articulos.csv");
					DataOutputStream  escritor = new DataOutputStream (fichero);) {
				
				ArrayList<Articulo> listaArticulos = almacen.buscarTodos();
				
				for(Articulo a3 : listaArticulos) {
					try {
						escritor.writeUTF(a3.getNombre());
						escritor.writeDouble(a3.getPrecio());
						escritor.writeInt(a3.getStock());
						escritor.writeInt(a3.getId());
						escritor.writeUTF(a3.getDescripcion());
					} catch (IOException e) {
						System.out.println("Error al abrir el fichero");
						e.printStackTrace();
					}
				}
			} catch (IOException e1) {
				System.out.println("Error al abrir el fichero");
				e1.printStackTrace();
			}
			break;
		
		default:
			System.out.println("Error");
		}
		
		opcion = cargarMenu();
		}
		
		if (opcion == 6) {
			System.out.println("Guardando los datos en el fichero...");
			try(FileOutputStream fos = new FileOutputStream(fn);
					ObjectOutputStream oos = new ObjectOutputStream(fos);){
				oos.writeObject(almacen);
				System.out.println("Datos guardados");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Cerrando programa");
		}
	}
	/**
	 * Método que muestra por consola un menú para que el usuario elija la acción a llevar a cabo
	 * 
	 * @return devuelve un número del 1 al 6 en función de la opción escogida por el usuario
	 */
	public static int cargarMenu() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		 System.out.println(" ------ MENÚ ------- ");
		 System.out.println("1. Añadir nuevo artículo");
		 System.out.println("2. Borrar un artículo por ID");
		 System.out.println("3. Obtener un artículo por ID");
		 System.out.println("4. Listar todos los artículos");
		 System.out.println("5. Exportar artículos a archivo CSV");
		 System.out.println("6. Salir");
		 
		 while(opcion > 6 || opcion < 1) {
			 System.out.println("Introduce el número de la opción elegida:");
			 try {
			 opcion = sc.nextInt();
			 } catch (NumberFormatException e) {
				 System.out.println("Error -> Introduce un dato de tipo numérico");
			 } catch (Exception e) {
				 System.out.println("Error genérico");
			 }
			 
		 }
		 return opcion;
	}
	
	/**
	 * Método que permite que el usuario introduzca los datos que se usarán para dar valor
	 * a los atributos de un nuevo objeto de tipo Articulo
	 *  
	 * @return a, un objeto de tipo Articulo cuyos atributos son los datos introducidos
	 */
	public static Articulo pedirDatosArticulo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el nombre del artículo:");
		String nombre = sc.nextLine();
		System.out.println("Escribe la descripción del artículo:");
		String desc = sc.nextLine();
		System.out.println("Escribe la cantidad:");
		int stock = sc.nextInt();
		System.out.println("Escribe el precio del artículo:");
		Double precio = sc.nextDouble();
		
		Articulo a = new Articulo();
		a.setNombre(nombre);
		a.setDescripcion(desc);
		a.setStock(stock);
		a.setPrecio(precio);
		
		return a;
	}

}
