package es.beatkapo.bibliotecapp.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * Clase que representa un usuario
 */
public class Usuario {
    /**
     * Nombre del usuario
     */
    private String dni;
    /**
     * Nombre del usuario
     */
    private Date fechaAltaSancion;

    /**
     * Metodo para sancionar a un usuario
     */
    public void sancionar() {
        fechaAltaSancion = new Date();
    }

    /**
     * Metodo para quitar la sancion a un usuario
     */
    public void quitarSancion() {
        fechaAltaSancion = null;
    }

    @Override
    public String toString() {
        return dni;
    }
}
