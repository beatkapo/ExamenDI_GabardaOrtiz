package es.beatkapo.bibliotecapp.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
  @Test
  //Test con libros y usuarios existentes
    void testDatosExistentes() {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro( 1, "titulo", "isbn", "autor", Tematica.Novela, new Date());
        Usuario usuario = new Usuario("dni", null);
        //Alta Libro
        biblioteca.altaLibro(libro);
        //Alta Usuario
        biblioteca.altaUsuario(usuario);
        //Prestar Libro
        biblioteca.prestarLibro(libro.getId(), usuario.getDni());
        assertNotNull(biblioteca.getPrestamos().getFirst());
        //Devolver Libro
        biblioteca.devolverLibro(libro.getId(), usuario.getDni());
        assertEquals(0, biblioteca.getPrestamos().size());
    }
    @Test
    //Test con libros y usuarios inexistentes
    void testDatosInxistentes() {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro( 1, "titulo", "isbn", "autor", Tematica.Novela, new Date());
        Usuario usuario = new Usuario("dni", null);
        //Prestar Libro
        assertFalse(biblioteca.prestarLibro(libro.getId(), usuario.getDni()));
        //Devolver Libro
        biblioteca.devolverLibro(libro.getId(), usuario.getDni());
        assertEquals(0, biblioteca.getPrestamos().size());
    }
    @Test
    //Test intentando añadir un libro con el mismo id
    void testAltaLibroMismoId() {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro( 1, "titulo", "isbn", "autor", Tematica.Novela, new Date());
        //Alta Libro
        biblioteca.altaLibro(libro);
        //Alta Libro
        biblioteca.altaLibro(libro);
        assertEquals(1, biblioteca.getLibros().size());
    }
    @Test
    //Test intentando añadir un libro con el mismo isbn
    void testAltaLibroMismoIsbn() {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro( 1, "titulo", "isbn", "autor", Tematica.Novela, new Date());
        Libro libro2 = new Libro( 2, "titulo2", "isbn", "autor2", Tematica.Novela, new Date());
        //Alta Libro
        biblioteca.altaLibro(libro);
        //Alta Libro
        biblioteca.altaLibro(libro2);
        assertEquals(1, biblioteca.getLibros().size());
    }
}