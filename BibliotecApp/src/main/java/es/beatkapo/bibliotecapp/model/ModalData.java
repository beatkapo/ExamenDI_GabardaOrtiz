package es.beatkapo.bibliotecapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que usa para compartir datos entre ventanas
 */
public class ModalData {
    /**
     * Usuario que se va a prestar el libro
     */
    public static Usuario usuario;
    /**
     * Libro que se va a prestar o crear
     */
    public static Libro libro;
    /**
     * Lista de usuarios
     */
    public static List<Usuario> usuarios = new ArrayList<>();
    /**
     * Lista de libros
     */
    public static List<Libro> libros = new ArrayList<>();

}
