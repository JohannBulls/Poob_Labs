package domain;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * IEMOIS
 * 
 * @author POOB
 * @version ECI 2022
 */

public class IEMOIS {
    private LinkedList<Program> programs;
    private HashMap<String, Course> courses;

    /**
     * Create a IEMOIS
     */
    public IEMOIS() {
        programs = new LinkedList<Program>();
        courses = new HashMap<String, Course>();
        addSome();
    }

    private void addSome() {
        String[][] courses = { { "Aprendiendo a Aprender. MacMaster-California. Coursera", "41" },
                { "Introduction to Computer Science and Programming Using Python", "75" },
                { "Databases: Modeling and Theory", "50" }, { "Databases: Relational Databases and SQL", "50" },
                { "Databases: Advances Topics in SQL", "50" }, { "Databases: Semistructured Data", "50" },
                { "Machine Learning", "95" }, { "Natural Computing", "5" } };
        for (String[] c : courses) {
            try {
                addCourse(c[0], c[1]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        String[][] specializations = {
                { "Developing Databases. Stanford Online. Edx.", "50",
                        "Databases: Modeling and Theory\nDatabases: Relational Databases and SQL" },
                { "Advanced Topics of Databases. Standford Online. Edx.", "10",
                        "Databases: Advances Topics in SQL\nDatabases: Semistructured Data" } };
        for (String[] s : specializations) {
            addSpecialization(s[0], s[1], s[2]);
        }
        String[][] nanodegree = { { "Artificial Inteligence", "3", "Natural Computing\nMachine Learning" } };
        for (String[] n : nanodegree) {
            addNanodegree(n);
        }
    }

    /**
     * Consult a program
     * 
     * @param name
     * @return
     */
    public Program consult(String name) {
        Program p = null;
        for (int i = 0; i < programs.size() && p == null; i++) {
            if (programs.get(i).name().equals(name))
                p = programs.get(i);
        }
        return p;
    }

    /**
     * Add a new course
     * 
     * @param name
     * @param price
     */
    public void addCourse(String name, String price) throws IEMOISException {
        if (!courses.containsKey(name.toUpperCase())) {
            try {
                Course nc = new Course(name, Integer.parseInt(price));
                nc.weeks();
                programs.add(nc);
                courses.put(name.toUpperCase(), nc);
            } catch (Exception e) {
                int promedio = calculateAvg();
                addCourse(name, Integer.toString(promedio));
            }
        } else {
            throw new IEMOISException(IEMOISException.COURSE_EXIST);
        }

    }

    /**
     * Add a new specialization
     * 
     * @param name
     * @param discount
     * @param courses
     */
    public void addSpecialization(String name, String discount, String courses) {
        Specialization s = new Specialization(name, Integer.parseInt(discount));
        String[] aCourses = courses.split("\n");
        for (String p : aCourses) {
            s.addCourse(this.courses.get(p.toUpperCase()));
        }
        programs.add(s);

    }

    /**
     * Add a new nanodegree
     * 
     * @param nanodegree
     */
    public void addNanodegree(String[] nanodegree) {
        Nanodegree nd = new Nanodegree(nanodegree[0], Integer.parseInt(nanodegree[1]));
        String[] course = nanodegree[2].split("\n");
        for (String n : course) {
            nd.addCourse(this.courses.get(n.toUpperCase()));
        }
        programs.add(nd);
    }

    /**
     * Consults the programs that start with a prefix
     * 
     * @param
     * @return
     */
    public LinkedList<Program> select(String prefix) {
        LinkedList<Program> answers = null;
        prefix = prefix.toUpperCase();
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).name().toUpperCase().startsWith(prefix)) {
                answers.add(programs.get(i));
            }
        }
        return answers;
    }

    /**
     * Consult selected programs
     * 
     * @param selected
     * @return
     */
    public String data(LinkedList<Program> selected) {
        StringBuffer answer = new StringBuffer();
        answer.append(programs.size() + " programas\n");
        for (Program p : programs) {
            try {
                answer.append(p.data());
                answer.append("\n");
            } catch (IEMOISException e) {
                answer.append("**** " + e.getMessage());
            }
        }
        return answer.toString();
    }

    /**
     * Return the data of programs with a prefix
     * 
     * @param prefix
     * @return
     */
    public String search(String prefix) {
        return data(select(prefix));
    }

    /**
     * Return the data of all programs
     * 
     * @return
     */
    public String toString() {
        return data(programs);
    }

    /**
     * Consult the number of Programs
     * 
     * @return
     */
    public int numberPrograms() {
        return programs.size();
    }

    /**
     * Calculate the courses week average .
     * 
     * @return the average.
     */
    private int calculateAvg() {
        int avg = 0;
        for (String c : courses.keySet()) {
            avg += courses.get(c).getWeeks();
        }
        return avg / courses.size();
    }

}
