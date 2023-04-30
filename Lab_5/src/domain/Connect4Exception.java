package domain;

public class Connect4Exception extends Exception {
    public static final String WIN = "!FELICIDADES! , Ganaste";
    public static final String NO_SPACE = "Ya no hay mas espacio en esa columna, porfavor selecciona otra";
    public static final String SAME_COLOR = "El otro jugador ya tiene ese color, porfavor escoja otro";
    public static final String BAD_INPUT = "No ingresaste un numero, ingrese uno";

    public Connect4Exception(String msm) {
        super(msm);
    }

}