import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase para representar una fecha.
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    /**
     * Construye una fecha con los parámetros proporcionados.
     *
     * @param pDia  Día de la fecha. pDia > 0 y pDia <= 31 y pDia es un valor válido según el mes.
     * @param pMes  Mes de la fecha. pMes > 0 y pMes <= 12.
     * @param pAnio Año de la fecha. pAnio > 0.
     */
    public Fecha(int pDia, int pMes, int pAnio) {
        dia = pDia;
        mes = pMes;
        anio = pAnio;
    }

    public Fecha() {
        dia=0;
        mes=0;
        anio=0;
    }

    /**
     * Retorna el día de la fecha.
     *
     * @return Día de la fecha.
     */
    public int darDia() {
        return dia;
    }

    /**
     * Retorna el mes de la fecha.
     *
     * @return Mes de la fecha.
     */
    public int darMes() {
        return mes;
    }

    /**
     * Retorna el año de la fecha.
     *
     * @return Año de la fecha.
     */
    public int darAnio() {
        return anio;
    }

    /**
     * Retorna la diferencia en meses que hay entre dos fechas.
     *
     * @param pFecha Fecha contra la que se está comparando. pFecha != null.
     * @return Diferencia en meses de las fechas.
     */

    /**
     * Retorna la fecha actual.
     *
     * @return Fecha actual.
     */
    public static Fecha darFechaActual() {
        GregorianCalendar gc = new GregorianCalendar();

        int diaActual = gc.get(Calendar.DAY_OF_MONTH);
        int mesActual = gc.get(Calendar.MONTH) + 1;
        int anioActual = gc.get(Calendar.YEAR);

        return new Fecha(diaActual, mesActual, anioActual);
    }

    /**
     * Retorna una cadena que representa la fecha.
     *
     * @return Cadena con la información de la fecha, sigue el formato día/mes/año.
     */
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}
