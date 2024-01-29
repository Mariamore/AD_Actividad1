package gestorArticulos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	//Creamos la variable contadorId para que el atributo Id no se repita
	private static int contadorId = 0;

	public static void main(String[] args) {
		
		File file = new File("articulos.dat");
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		
		// Comprobamos si existe el fichero
		if (file.exists()) {
			try(FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis);){
				// Llenamos la colección de artículos
				listaArticulos = (List<Articulo>) ois.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Si no existe, listaArticulos sigue existiendo, aunque esté vacía.
		int opcion = 0;
		do {
			opcion = menu();
			switch(opcion) {
			case 1:
				listaArticulos = anadirArticulo(listaArticulos);
				break;
			case 2:
				listaArticulos = borrarArticulo(listaArticulos);
				break;
			case 3:
				listaArticulos = consultarArticulo(listaArticulos);
				break;
			case 4:
				listaArticulos = listarArticulos(listaArticulos);
				break;
			case 5:
				listaArticulos = exportarCsv(listaArticulos);
			case 6:
				sobreescribirFichero(listaArticulos);
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}while(opcion != 6);
		System.out.println("Programa terminado correctamente");

	}
	
	public static int menu() {
		
		System.out.println("------------ MENÚ ------------");
		System.out.println("1. Añadir nuevo artículo");
		System.out.println("2. Borrar artículo por Id");
		System.out.println("3. Consulta de artículo por Id");
		System.out.println("4. Listado de todos los artículos");
		System.out.println("5. Exportar artículos a archivo CSV");
		System.out.println("6. Terminar el programa");
		System.out.println("------------------------------");
		System.out.println("Por favor, introduzca el número de opción deseada: ");
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		return opcion;
		
	}
	
	public static List<Articulo> anadirArticulo(List<Articulo> listaArticulos) {
		
		Articulo articulo = new Articulo();
		//Sumamos 1 al contador de Id para que no se repita nunca
		articulo.setId(++contadorId);
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del artículo: ");
		articulo.setNombre(sc.nextLine());
		System.out.println("Introduzca la descripción del artículo: ");
		articulo.setDescripcion(sc.nextLine());
		System.out.println("Introduzca el número de stock disponible: ");
		articulo.setStock(sc.nextInt());
		System.out.println("Introduzca el precio del artículo: ");
		articulo.setPrecio(sc.nextDouble());
		listaArticulos.add(articulo);
		System.out.println("Artículo creado correctamente");
		return listaArticulos;
	}
	
	public static List<Articulo> borrarArticulo(List<Articulo> listaArticulos) {
		System.out.println("Introduzca el Id del artículo a eliminar: ");
		Scanner sc = new Scanner(System.in);
		int idArticulo = sc.nextInt();
		for (Articulo art : listaArticulos) {
			if (art.getId() == idArticulo) {
				listaArticulos.remove(art);
				System.out.println("Artículo borrado correctamente");
				break;
			}
		}
		return listaArticulos;
	}
	
	public static List<Articulo> consultarArticulo(List<Articulo> listaArticulos) {
		System.out.println("Introduzca el Id del artículo a consultar: ");
		Scanner sc = new Scanner(System.in);
		int idArticulo = sc.nextInt();
		for (Articulo art : listaArticulos) {
			if (art.getId() == idArticulo) {
				System.out.println("Datos del artículo solicitado: ");
				System.out.println(art);
			}
		}
		return listaArticulos;
	}
	
	public static List<Articulo> listarArticulos(List<Articulo> listaArticulos) {
		System.out.println("Listado de todos los artículos: ");
		for (Articulo art : listaArticulos) {
			System.out.println(art);
		}
		return listaArticulos;
	}
	
	public static List<Articulo> exportarCsv(List<Articulo> listaArticulos){
		//Pondremos false para que sobreescriba el fichero si existe
				try(FileOutputStream fos = new FileOutputStream("articulos.csv",false);
						DataOutputStream dos = new DataOutputStream(fos);){
					
					for(Articulo art : listaArticulos) {
						dos.writeInt(art.getId());
						dos.writeUTF(art.getNombre());
						dos.writeUTF(art.getDescripcion());
						dos.writeInt(art.getStock());
						dos.writeDouble(art.getPrecio());
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		return listaArticulos;
	}
	
	public static void sobreescribirFichero(List<Articulo> listaArticulos) {
		//Pondremos false para que sobreescriba el fichero si existe
		try(FileOutputStream fos = new FileOutputStream("articulos.dat",false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(listaArticulos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
