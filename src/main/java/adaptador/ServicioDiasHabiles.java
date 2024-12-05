/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adaptador;

import java.util.Date;

/**
 *
 * @author scocl
 */
public interface ServicioDiasHabiles {
    boolean esDiaHabil(Date fecha);
    Date calcularFechaVencimiento(Date fechaActual, int diasProrroga);
}