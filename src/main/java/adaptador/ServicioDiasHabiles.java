/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package adaptador;

import java.util.Date;

public interface ServicioDiasHabiles {
    boolean esDiaHabil(Date fecha);
    Date calcularFechaVencimiento(Date fechaActual, int diasProrroga);
}