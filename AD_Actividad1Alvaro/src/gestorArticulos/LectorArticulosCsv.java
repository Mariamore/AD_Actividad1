package gestorArticulos;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


public class LectorArticulosCsv {

	public static void main(String[] args) {
		
		// Clase creada para leer el contenido del fichero articulos.csv
		
		try(FileInputStream fis = new FileInputStream("articulos.csv");
				DataInputStream dis = new DataInputStream(fis);){
			boolean eof = false;
			
			while (!eof) {
				try {
					int id = dis.readInt();
					String nombre = dis.readUTF();
					String descripcion = dis.readUTF();
					int stock = dis.readInt();
					double precio = dis.readDouble();
					Articulo art = new Articulo(id,nombre,descripcion,stock,precio);
					System.out.println(art);
				} catch (EOFException e1) {
					eof = true;
				} catch (IOException e2) {
					System.out.println("Error al leer los registros");
					System.out.println(e2.getMessage());
					break; // sale del bucle while
				}
			}
		} catch (IOException e) {
			System.out.println("Error al abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}
			

	}

}
