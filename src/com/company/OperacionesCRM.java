package com.company;

import java.util.List;

public interface OperacionesCRM {

    List<Libro> findAll();
    Libro findByISBN(String isbn);
    void deleteLibro(String isbn);
    void insertLibro(Libro libro);
    void deleteAll();


}
