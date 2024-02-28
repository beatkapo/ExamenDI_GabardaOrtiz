package es.beatkapo.bibliotecapp.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * Clase que representa un libro
 */
public class Libro {
    /**
     * Identificador del libro
     */
    private int id;
    /**
     * Título del libro
     */
    private String titulo;
    /**
     * ISBN del libro
     */
    private String isbn;
    /**
     * Autor del libro
     */
    private String autor;
    /**
     * Temática del libro
     */
    private Tematica tematica;
    /**
     * Fecha de edición del libro
     */
    private Date fechaEdicion;

    @Override
    public String toString() {
        return "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", tematica=" + tematica;
    }
}
