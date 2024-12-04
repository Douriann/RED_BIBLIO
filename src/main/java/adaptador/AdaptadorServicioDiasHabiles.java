/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptador;

import java.util.Calendar;
import java.util.Date;

public class AdaptadorServicioDiasHabiles implements ServicioDiasHabiles {
    
    @Override
    public boolean esDiaHabil(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        return diaSemana != Calendar.SATURDAY && diaSemana != Calendar.SUNDAY;
    }

    public Date calcularFechaVencimiento(Date fechaActual, int diasProrroga) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaActual);
        int dias = 0;
        while (dias < diasProrroga) {
            calendario.add(Calendar.DAY_OF_YEAR, 1);
            if (esDiaHabil(calendario.getTime())) {
                dias++;
            }
        }
        // Si el día de vencimiento cae en un día no hábil, mover al próximo día hábil
        while (!esDiaHabil(calendario.getTime())) {
            calendario.add(Calendar.DAY_OF_YEAR, 1);
        }
        return calendario.getTime();
    }
}