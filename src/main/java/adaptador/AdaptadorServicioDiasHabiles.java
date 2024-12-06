/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package adaptador;

import java.util.Calendar;
import java.util.Date;

public class AdaptadorServicioDiasHabiles implements ServicioDiasHabiles {
    
    @Override
    // METODO QUE COMPRUEBA LOS DIAS HÁBILES
    public boolean esDiaHabil(Date fecha) {
        // OBTIENE UNA INSTANCIA DE CALENDAR
        Calendar calendario = Calendar.getInstance();
        // ESTABLECE LA FECHA ACTUAL
        calendario.setTime(fecha);
        // OBTIENE EL DIA CORRESPONDIENTE A LA FECHA ACTUAL
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        // DEVUELVE TRUE SI EL DIA NO ES SÁBADO NI DOMINGO
        return diaSemana != Calendar.SATURDAY && diaSemana != Calendar.SUNDAY;
    }
    // METODO PARA CALCULAR LA FECHA DE VENCIMIENTO DEL PRESTAMO TOMANDO EN CUENTA LOS DIAS NO HABILES
    public Date calcularFechaVencimiento(Date fechaActual, int diasProrroga) {
        // OBTIENE UNA INSTANCIA DE CALENDAR
        Calendar calendario = Calendar.getInstance();
        // ESTABLECE LAA FECHA ACTUAL
        calendario.setTime(fechaActual);
        // INICIALIZA UN CONTADOR DE DIAS PARA LA COMPROBACIÓN EN DIAS DE SEMANA
        int dias = 0;
        while (dias < diasProrroga) {
            calendario.add(Calendar.DAY_OF_YEAR, 1);
            if (esDiaHabil(calendario.getTime())) {
                dias++;
            }
            else break;
        }
        // SI EL DIA DE VENCIMIENTO CAE EN UN DIA NO HABIL, MOVER AL PROXIMO DIA HABIL
        while (!esDiaHabil(calendario.getTime())) {
            calendario.add(Calendar.DAY_OF_YEAR, 1);
        }
        return calendario.getTime();
    }
}