package domain;

/**
 * The exception class of IEMOIS
 * 
 * @author Johann Amaya Lopez
 * @author Sebastian Zamora Urrego
 * @version 1.0
 */
public class IEMOISException extends Exception {
    public static final String WEEKS_EMPTY = "No hay numero de semanas establecidas";
    public static final String WEEKS_ERROR = "Numero erroneo de semanas";
    public static final String NANO_EMPTY = "El nano no tiene cursos";
    public static final String IMPOSSIBLE = "Hay errores en los cursos";
    public static final String COURSE_EXIST = "Curso ya existe";

    /**
     * Constructor for objects of class IEMOISException
     */
    public IEMOISException(String msm) {
        super(msm);
    }
}
