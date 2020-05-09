package LabAssiAsseProjectV04;
import Validator.*;
import Service.*;
import Repository.*;
import Domain.*;
import org.junit.Test;
import org.junit.Before;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IncrementalTest {
    private ServiceNote serviceNote;
    private ServiceStudent serviceStudent;
    private ServiceTeme serviceTeme;

    @Before
    public void setUp() throws Exception{
        PrintWriter writer = new PrintWriter("StudentiXL.xml");
        writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<inbox>\n" +
                    "<Student idStudent=\"1\">\n" +
                        "<nume>Axinie</nume>\n" +
                        "<grupa>931</grupa>\n" +
                        "<mail>axiniuc@gmail.com</mail>\n" +
                        "<profesor>prof</profesor>\n" +
                    "</Student>\n" +
                "</inbox>\n");
        writer.close();
        PrintWriter writer1 = new PrintWriter("TemeXL.xml");
        writer1.print("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<Teme>\n" +
                "    <Tema nr=\"3\">\n" +
                "        <descriere>tema grea</descriere>\n" +
                "        <deadline>10</deadline>\n" +
                "        <sapt_primire>4</sapt_primire>\n" +
                "    </Tema>\n" +
                "</Teme>");
        writer1.close();
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Teme> temeValidator = new TemeValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator, "StudentiXL.xml");
        TemeRepo temeRepo = new TemeRepo(temeValidator, "TemeXL.xml");
        NoteRepo noteRepo = new NoteRepo(notaValidator);
        this.serviceStudent = new ServiceStudent(studentRepo);
        this.serviceTeme = new ServiceTeme(temeRepo);
        this.serviceNote = new ServiceNote(noteRepo);
    }

    @Test
    public void testAddStudentInc() throws ValidationException {
        Student student = new Student("2", "Belcianu", 931, "cata@gmail.com", "prof");
        assertEquals(student, this.serviceStudent.add(student));
    }

    @Test
    public void testAddStudentAndAssignmentInc() throws  ValidationException {
        Teme tema = new Teme(4, "tema obligatorie", 6, 9);
        Student student = new Student("3", "Someone", 932, "email@gmail.com", "prof");

        assertEquals(tema, this.serviceTeme.add(tema));
        assertEquals(student, this.serviceStudent.add(student));
    }
    @Test
    public void testAddAllInc() throws ValidationException {
        Teme tema = new Teme(5, "tema usoara", 7, 8);
        Student student = new Student("4", "SomeoneElse", 933, "email2@gmail.com", "prof");
        Map<String, Integer> idmap = new HashMap<>();
        idmap.put("1", 1);
        Set ceva =idmap.entrySet();
        Nota nota = new Nota((Map.Entry<String, Integer>) ceva.toArray()[0],student, tema, 7, 10);

        assertEquals(tema, this.serviceTeme.add(tema));
        assertEquals(student, this.serviceStudent.add(student));
        assertEquals(nota, this.serviceNote.add(nota, "good"));
    }
}
