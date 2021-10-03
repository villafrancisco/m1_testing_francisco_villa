package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
//Aplicacion para gestionar Libros
    public static void main(String[] args) {

        // Creo el objeto scanner
        Scanner scanner = new Scanner(System.in);

        //Creo la lista de libros
        List<Libro> listaLibros=new ArrayList<>();
        //Interfaz para manejar los libros
        OperacionesCRM crm=new Operaciones(listaLibros);


        while(true) {
            System.out.println("****************************");
            System.out.println("Selecciona una opción:");
            System.out.println("1 - Ver todos los libros");
            System.out.println("2 - Ver un libro(por ISBN)");
            System.out.println("3 - Insertar un nuevo libro");
            System.out.println("4 - Modificar un libro (por ISBN)");
            System.out.println("5 - Eliminar un libro (por ISBN)");
            System.out.println("6 - Eliminar todos los libros");
            System.out.println("7 - Salir");
            System.out.println("****************************");
            System.out.println("Introduce una opción:");


                int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Has seleccionado la opción 1 - Ver todos los libros");
                    List<Libro> libros = crm.findAll();
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros.");
                    } else {
                        System.out.println(libros);
                        System.out.println("El número de libros es: " + libros.size());
                    }
                }
                case 2 -> {
                    System.out.println("Has seleccionado la opción 2 - Ver un libro.");
                    System.out.println("Introduce el ISBN del libro para consultar:");
                    String isbn = scanner.next();
                    Libro libro = crm.findByISBN(isbn);
                    if (Objects.isNull(libro)) {
                        System.out.println("El libro con isbn " + isbn + " no existe");
                    } else {
                        System.out.println(libro);
                    }
                }
                case 3 -> {
                    System.out.println("Has seleccionado la opción 3 - Insertar un  nuevo libro.");
                    System.out.println("Introduce el isbn:");
                    String isbnInsertar = scanner.next();
                    Libro libroBuscado = crm.findByISBN(isbnInsertar);
                    if (Objects.isNull(libroBuscado)) {
                        System.out.println("Introduce el título:");
                        String titulo = scanner.next();
                        System.out.println("Introduce el autor:");
                        String autor = scanner.next();
                        System.out.println("Introduce el numero de paginas");
                        int paginas = scanner.nextInt();
                        Libro libroInsertar = new Libro(isbnInsertar, titulo, autor, paginas);
                        crm.insertLibro(libroInsertar);
                        System.out.println("El libro " + libroInsertar + "ha sido guardado.");

                    } else {
                        System.out.println("El isbn está ocupado, utilice otro isbn.");
                    }
                }
                case 4 -> {
                    System.out.println("Has seleccionado la opción 4 - Modificar un libro.");
                    System.out.println("Introduce el isbn del libro para modificar:");
                    String isbnModificar = scanner.next();
                    Libro libroModificar = crm.findByISBN(isbnModificar);
                    if (Objects.isNull(libroModificar)) {
                        System.out.println("El libro con isbn " + isbnModificar + " no existe");
                    } else {
                        System.out.println("Introduce el título:");
                        libroModificar.setTitulo(scanner.next());
                        System.out.println("Introduce el autor:");
                        libroModificar.setAutor(scanner.next());
                        System.out.println("Introduce el numero de paginas");
                        libroModificar.setPaginas(scanner.nextInt());
                        System.out.println("El libro " + libroModificar + "ha sido guardado.");
                    }
                }
                case 5 -> {
                    System.out.println("Has seleccionado la opción 5 - Elimina un libro por isbn.");
                    System.out.println("Introduce el ISBN del libro para consultar:");
                    String isbnBorrar = scanner.next();
                    Libro libroBorrar = crm.findByISBN(isbnBorrar);
                    if (Objects.isNull(libroBorrar)) {
                        System.out.println("El libro con isbn " + isbnBorrar + " no existe");
                    } else {
                        crm.deleteLibro(isbnBorrar);
                        System.out.println("El libro ha sido borrado correctamente");
                    }
                }
                case 6 -> {
                    System.out.println("Has seleccionado la opción 6 - Borra todos los libros.");
                    crm.deleteAll();
                    System.out.println("Borrados todos los libros.");
                }
                case 7 -> {
                    System.out.println("Muchas gracias por utilizar el programa. Hasta pronto");
                    return;
                }
            }

        }
    }
}
