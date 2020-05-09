package LabAssiAsseProjectV04;

import Domain.Nota;
import Domain.Student;
import Domain.Teme;
import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceNote;
import Service.ServiceStudent;
import Service.ServiceTeme;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    @Test
    public void testAddStudent() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("1", "Axinie", 931, "axiniuc@gmail.com", "prof");

        stsrv.add(student);
        assertEquals(931, stsrv.find("1").getGrupa());
        assertEquals(2, stsrv.size());
    }

    @Test
    public void testAddAssignment() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "teme.xml");
        ServiceTeme st = new ServiceTeme(tr);
        Teme tema = new Teme(1, "O tema", 10, 12);

        try {
            st.add(tema);
        }catch(Exception e) {
            assert(false);
        }
    }

    @Test
    public void testAddGrade() {
        NotaValidator nv = new NotaValidator();
        NoteRepo nr = new NoteRepo(nv);
        ServiceNote sn = new ServiceNote(nr);

        Student student = new Student("1", "Axinie", 931, "axiniuc@gmail.com", "prof");
        Teme tema = new Teme(1, "O tema", -3, 12);


        Map.Entry<String, Integer> mapa = new AbstractMap.SimpleEntry<>("1", 1);
        Nota nota = new Nota(mapa, student, tema, 8.5f, 9);

        Nota addedN = sn.add(nota, "O nota ff buna");
        assertEquals(addedN.getID(), mapa);
    }

    @Test
    public void integrate() {
        testAddStudent();
        testAddAssignment();
        testAddGrade();
    }
}
