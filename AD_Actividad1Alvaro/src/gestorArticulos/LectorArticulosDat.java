package gestorArticulos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LectorArticulosDat {

	public static void main(String[] args) {
		
		// Clase creada para leer el contenido del fichero articulos.dat
		
		File file = new File("articulos.dat");
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			List<Articulo> listaArticulos = (List<Articulo>) ois.readObject();
			for(Articulo art : listaArticulos) {
				System.out.println(art);
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
