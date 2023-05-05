package domain;

public class AutomataException extends Exception{
    public static final String OPEN = "OPCION OPEN EN CONSTRUCCION";
    public static final String SAVE = "OPCION SAVE EN CONSTRUCCION";
    public static final String IMPORT = "OPCION IMPORT EN CONSTRUCCION";
    public static final String EXPORT = "OPCION EXPORT EN CONSTRUCCION";

    public AutomataException(String msm,String nombre){
        super(msm +".Archivo "+nombre);
    }
}