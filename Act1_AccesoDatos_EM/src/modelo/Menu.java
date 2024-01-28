package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        Articulos articulos = new Articulos(0, "", "", 0, 0.0);

        
        File file = new File("articulos.dat");
        
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            	 articulos.setListaArticulos((List<Articulos>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo " + file.getName() + " no existe");
        }
        
        System.out.println("Bienvenido al almacen de articulos"); 
        Scanner entradaCliente = new Scanner(System.in);
        
        int opcion = 0;
        
        Articulos.cargarDatos();
        
        while (opcion != 6) {
            mostrarMenu();
            opcion = entradaCliente.nextInt();
            entradaCliente.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Nombre de articulo que quiere añadir");
                    String nombre = sc.nextLine();
                    System.out.println("Descripcion del articulo");
                    String descripcion = sc.nextLine();
                    System.out.println("Stock del articulo");
                    int stock = sc.nextInt();
                    System.out.println("Precio articulo");
                    double precio = sc.nextDouble();
                    // Crear un nuevo objeto con los datos añadidos
                    Articulos articuloNuevo = new Articulos(articulos.getListaArticulos().size() + 1, nombre, descripcion, stock, precio);
                    // Añadir el nuevo artículo a la lista
                    if (articulos.añadirArticulo(articuloNuevo)) {
                        System.out.println("Articulo añadido correctamente.");
                    } else {
                        System.out.println("Error al añadir el articulo.");
                    }
                    break;
                case 2:
                    System.out.println("Id del articulo que desea eliminar");
                    int idEliminar = sc.nextInt();
                    Articulos articuloEliminar = articulos.consultarArticuloId(idEliminar);
                    if (articulos.borrarArticulo(articuloEliminar)) {
                        System.out.println("Articulo eliminado");
                    } else {
                        System.out.println("Articulo no eliminado");
                    }
                    break;
                case 3:
                    System.out.println("Id del articulo a consultar");
                    int idConsulta = sc.nextInt();
                    Articulos aConsulta =  articulos.consultarArticuloId(idConsulta); 
                    if(aConsulta !=null) {
                        System.out.println("Articulo:");
                        System.out.println(aConsulta);
                    } else {
                        System.out.println("No existe el ID del articulo");
                    }
                    break;
                case 4:
                    System.out.println("Listado de articulos: ");
                    for(Articulos listarArticulos: Articulos.listadoArticulos()) {
                        System.out.println(listarArticulos);
                    }
                    break;

                case 5:
                    System.out.println("Exportando archivo csv...");
                    try (FileOutputStream f = new FileOutputStream("articulos.csv", true);
                         ObjectOutputStream obj = new ObjectOutputStream(f)) {

                        obj.writeObject(Articulos.getListaArticulos());
                        System.out.println("Archivo exportado");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                    break;
                case 6:
                    System.out.println("Final del programa");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Añadir nuevo articulo");
        System.out.println("2. Borrar articulo");
        System.out.println("3. Consultar articulo por id");
        System.out.println("4. Listado de todos los articulos");
        System.out.println("5. Exportar articulos a archivo csv");
        System.out.println("6. Salir del programa");
        System.out.print("Elige una opción: ");
    }
}

