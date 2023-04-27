package test;

import domain.*;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class IEMOIS
 *
 * @author Johann Amaya Lopez
 * @author Sebastian Zamora Urrego
 * @version 1.0
 */
public class IEMOISTest {
    @Test
    public void shouldAddCourses() {
        IEMOIS caja = new IEMOIS();
        try {
            caja.addCourse("Programaciión Orientada a Objetos", "7");
            caja.addCourse("Algoritmos y Estructuras de Datos", "7");
            caja.addCourse("Modelos de Bases de Datos", "7");
            caja.addCourse("Algoritmos y Programacion", "7");
            assertEquals(15, caja.numberPrograms());
        } catch (Exception e) {
            fail("Throw an Exception");
        }

    }

    @Test
    public void shouldNotAddCourseIfAlreadyAdd() {
        IEMOIS program = new IEMOIS();
        try {
            program.addCourse("Programaciión Orientada a Objetos", "7");
            program.addCourse("Algoritmos y Estructuras de Datos", "7");
            program.addCourse("Programaciión Orientada a Objetos", "7");
            fail("Not Threw an exception.");
        } catch (IEMOISException e) {
            assertEquals(e.getMessage(), IEMOISException.COURSE_EXIST);
        }
    }

    @Test
    public void shouldNotAddCoureIfTheWeeksNumberIsWrong() {
        IEMOIS program = new IEMOIS();
        try {
            program.addCourse("Programaciión Orientada a Objetos", "7");
            program.addCourse("Algoritmos y Estructuras de Datos", "7");
            program.addCourse("Modelos de Bases de Datos", "-7");
            fail("Not Threw an exception.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), IEMOISException.WEEKS_ERROR);
        }
    }

    @Test
    public void shouldNotAddCoureIfTheWeeksNumberIsEmpty() {
        IEMOIS program = new IEMOIS();
        try {
            program.addCourse("Programaciión Orientada a Objetos", "7");
            program.addCourse("Algoritmos y Estructuras de Datos", "7");
            program.addCourse("Modelos de Bases de Datos", "");
            fail("Not Threw an exception.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), IEMOISException.WEEKS_EMPTY);
        }
    }

    @Test
    public void shouldAddCoursesWithWrongAndEmptyWeeks() {
        IEMOIS caja = new IEMOIS();
        try {
            caja.addCourse("Programaciión Orientada a Objetos", "7");
            caja.addCourse("Algoritmos y Estructuras de Datos", "-7");
            caja.addCourse("Modelos de Bases de Datos", "");
            assertEquals(14, caja.numberPrograms());
        } catch (Exception e) {
            fail("Throw an Exception");
        }
    }
}
