package com.company;

import java.util.ArrayList;
import java.util.List;

public class Operaciones implements OperacionesCRM{

    List<Libro> listaLibros;

    public Operaciones(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @Override
    public List<Libro> findAll() {
        return listaLibros;
    }

    @Override
    public Libro findByISBN(String isbn) {
        
        for(Libro libro:listaLibros){
            if(libro.getIsbn().equals(isbn)){
        
                return libro;
            }
        }
        return null;

    }

    @Override
    public void insertLibro(Libro libro) {
        listaLibros.add(libro);

    }

    @Override
    public void deleteAll() {
        listaLibros.clear();
    }

    @Override
    public void deleteLibro(String isbn) {
        listaLibros.removeIf((libro) -> libro.getIsbn().equals(isbn));
    }




}
