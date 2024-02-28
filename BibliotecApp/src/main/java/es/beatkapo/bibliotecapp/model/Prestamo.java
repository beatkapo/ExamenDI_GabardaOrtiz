package es.beatkapo.bibliotecapp.model;

import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * Clase que representa un préstamo
 */
public class Prestamo {
    /**
     * Identificador del libro prestado
     */
    private int idLibro;
    /**
     * DNI del usuario que ha prestado el libro
     */
    private String dniUsuario;
    /**
     * Fecha de devolución del libro
     */
    private Date fechaDevolucion;

    /**
     * Constructor de la clase con dos atributos. Crea un préstamo con la fecha de devolución 10 días después de la fecha actual
     * @param idLibro id del libro prestado
     * @param dniUsuario dni del usuario que ha prestado el libro
     */
    public Prestamo(int idLibro,String dniUsuario){
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        fechaDevolucion = calendar.getTime();
    }
}
