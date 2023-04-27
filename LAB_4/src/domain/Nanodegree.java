package domain;

import java.util.ArrayList;
import java.lang.Math;

public class Nanodegree extends Program {
    private int projectWeeks;
    private ArrayList<Course> courses;

    /**
     * Constructs a new nanodegree
     * 
     * @param name
     * @param discount
     */
    public Nanodegree(String name, int projectWeeks) {
        this.name = name;
        this.projectWeeks = projectWeeks;
        courses = new ArrayList<Course>();
    }

    /**
     * Add a new course
     * 
     * @param c
     */
    public void addCourse(Course c) {
        courses.add(c);
    }

    @Override
    public int weeks() throws IEMOISException {
        int weeks = 0;
        if (courses.size() == 0)
            throw new IEMOISException(IEMOISException.NANO_EMPTY);
        for (Course i : courses) {
            weeks += i.weeks();
        }
        return projectWeeks + weeks;
    }

    /**
     * Calculates an estimate of weeks
     * For courses where the weeks cannot be known or has error, the max, min or avg
     * of the known courses is assumed
     * 
     * @param type (max,min,avg)
     * @return
     * @throws IEMOISException NANO_EMPTY, if it don't have courses. IMPOSSIBLE, if
     *                         it can't be calculated
     */
    public int weeks(String type) throws IEMOISException {
        int weeks = projectWeeks;
        int error = 0;
        int cambio = cambio(type);
        if (courses.size() == 0)
            throw new IEMOISException(IEMOISException.NANO_EMPTY);
        for (Course i : courses) {
            try {
                weeks += i.weeks();
            } catch (IEMOISException e) {
                error++;
                weeks += cambio;
            }
        }
        if (error == courses.size())
            throw new IEMOISException(IEMOISException.IMPOSSIBLE);
        return weeks;
    }

    /**
     * Calculetes the max,min or avg dipents of the case.
     * 
     * @param type(max,min,avg)
     * @return the value that the type require me.
     */
    private int cambio(String type) {
        int valor = projectWeeks;
        int[] valores = verificacion();
        if (type.equals("max")) {
            for (int i = 0; i < courses.size() - 1; i++) {
                valor = Math.max(valores[0], valores[1]);
            }
        } else if (type.equals("min")) {
            for (int i = 0; i < courses.size() - 1; i++) {
                if (valores[i] > 0 && valores[i + 1] > 0 && Math.min(valores[0], valores[1]) < valor)
                    valor = Math.min(valores[0], valores[1]);
            }
        } else if (type.equals("avg")) {
            for (int i = 0; i < courses.size(); i++) {
                valor += courses.get(i).getWeeks();
            }
            valor = valor / courses.size();
        }
        return valor;
    }

    /**
     * Calculates an estimate of weeks
     * For courses where the weeks cannot be known, unknown is assumed
     * 
     * @param unknown the number of weeks that assume if the week has a error
     * @return The total course weeks.
     * @throws IEMOISException NANO_EMPTY, if it don't have courses. WEEKS_ERROR, if
     *                         some course has error
     */
    public int weeks(int unknown) throws IEMOISException {
        int valor = projectWeeks;
        if (courses.size() > 0) {
            for (Course i : courses) {
                try {
                    valor += i.weeks();
                } catch (IEMOISException e) {
                    if (e.getMessage().equals(IEMOISException.WEEKS_EMPTY)) {
                        valor += unknown;
                    } else {
                        throw new IEMOISException(IEMOISException.WEEKS_ERROR);
                    }
                }
            }
        }
        return valor;
    }

    @Override
    public String data() throws IEMOISException {
        StringBuffer answer = new StringBuffer();
        answer.append(name + ". Proyecto: " + projectWeeks);
        for (Course c : courses) {
            answer.append("\n" + c.data());
        }
        return answer.toString();
    }

    /**
     * Let me know if the number of weeks it's allirght.
     * 
     * @return The number of weeks.
     */
    private int[] verificacion() {
        int[] aux = new int[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getWeeks() < 0) {
                aux[i] = 0;
            } else {
                aux[i] = courses.get(i).getWeeks();
            }
        }
        return aux;
    }
}
