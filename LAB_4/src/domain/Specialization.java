package domain;

import java.util.ArrayList;
import java.util.List;

public class Specialization extends Program {

    private Integer weeks;
    private List<Course> courses = new ArrayList<>();

    public Specialization(String name, int discount) {
        this.name = name;
        this.weeks = discount;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public int weeks() throws IEMOISException {
        if (weeks == null)
            throw new IEMOISException(IEMOISException.WEEKS_EMPTY);
        if (weeks < 1)
            throw new IEMOISException(IEMOISException.WEEKS_ERROR);
        return weeks;
    }

    @Override
    public String data() {
        return name + ". Semanas:" + weeks;
    }
}