package es.beatkapo.bibliotecapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
/**
 * Clase que representa una biblioteca
 */
public class Biblioteca {
    /**
     * Lista de libros de la biblioteca
     */
    private List<Libro> libros;
    /**
     * Lista de usuarios de la biblioteca
     */
    private List<Usuario> usuarios;
    /**
     * Lista de prestamos de la biblioteca
     */
    private List<Prestamo> prestamos;

    /**
     * Constructor de la clase sin atributos, inicializa las listas.
     */
    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    /**
     * Método que permite prestar un libro a un usuario
     * @param idLibro id del libro a prestar
     * @param dniUsuario dni del usuario que presta el libro
     * @return true si el libro se ha prestado, false si no se ha podido prestar
     */

    public boolean prestarLibro(int idLibro, String dniUsuario) {
        if (libros.size() > 0 && usuarios.size() > 0) {
            Libro libro = libros.stream().filter(l -> l.getId() == idLibro).toList().getFirst();
            Usuario usuario = usuarios.stream().filter(u -> u.getDni().equals(dniUsuario)).toList().getFirst();

            if (usuario.getFechaAltaSancion() != null) {
                return false;
            }
            if (libro != null && usuario != null) {

                Prestamo prestamo = new Prestamo(idLibro, dniUsuario);
                prestamos.add(prestamo);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que permite devolver un libro a la biblioteca
     * @param idLibro id del libro a devolver
     * @param dniUsuario dni del usuario que devuelve el libro
     */
    public void devolverLibro(int idLibro, String dniUsuario) {
        if (libros.size() > 0 && usuarios.size() > 0) {
            Prestamo prestamo = prestamos.stream().filter(p -> p.getIdLibro() == idLibro && p.getDniUsuario().equals(dniUsuario)).toList().getFirst();
            Usuario usuario = usuarios.stream().filter(u -> u.getDni().equals(dniUsuario)).toList().getFirst();

            if (prestamo.getFechaDevolucion().after(new Date())) {
                usuario.sancionar();
            }
            if (prestamo != null) {
                prestamos.remove(prestamo);
            }
        }
    }

    /**
     * Método que permite añadir un libro a la biblioteca
     * @param libro libro a añadir
     */
    //He cambiado los atributos que recibe el metodo, me parece más correcto pasarle un Libro, ya que tiene su propio constructor.
    public void altaLibro(Libro libro) {
        //Comprobar que en la lista no exista un libro con el mismo id o el mismo isbn
        if (libros.stream().noneMatch(l -> l.getId() == libro.getId()) && libros.stream().noneMatch(l -> l.getIsbn().equals(libro.getIsbn()))) {
            libros.add(libro);
        }

    }

    /**
     * Método que permite eliminar un libro de la biblioteca
     * @param idLibro id del libro a eliminar
     */
    public void bajaLibro(int idLibro) {
        if (!libros.isEmpty()) {
            Libro libro = libros.stream().filter(l -> l.getId() == idLibro).findFirst().get();
            if (libro != null) {
                libros.remove(libro);
            }
        }

    }

    /**
     * Método que permite añadir un usuario a la biblioteca
     * @param usuario usuario a añadir
     */
    public void altaUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Método que permite eliminar un usuario de la biblioteca
     * @param dniUsuario dni del usuario a eliminar
     */
    public void bajaUsuario(String dniUsuario) {
        Usuario usuario = usuarios.stream().filter(u -> u.getDni().equals(dniUsuario)).findFirst().get();
        if (usuario != null) {
            usuarios.remove(usuario);
        }
    }

}
