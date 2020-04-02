package LabAssiAsseProjectV04;

import Domain.Student;
import Domain.Teme;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceStudent;
import Service.ServiceTeme;
import Validator.StudentValidator;
import Validator.TemeValidator;
import Validator.ValidationException;
import Validator.Validator;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Before
    public void setUp() throws Exception {
        PrintWriter writer = new PrintWriter("StudentiXL.xml");
        writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<inbox>\n" +
                "</inbox>\n");
        writer.close();
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAddStudent() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("1", "Axinie", 931, "axiniuc@gmail.com", "prof");

        stsrv.add(student);
        assertEquals(931, stsrv.find("1").getGrupa());
        assertEquals(1, stsrv.size());
    }

    @Test
    public void blackboxT1() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("2", "Someone", 931, "someone@gmail.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT2() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student(null, "SomeoneElse", 931, "someoneelse@gmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT3() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("-1", "SomeoneElse", 931, "someoneelse@gmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT4() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("0", "SomeoneElse", 931, "someoneelse@gmail.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT5() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("6", "SomeoneElse", 110, "someoneelse@gmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT6() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("7", "SomeoneElse", 111, "someoneelse@gmail.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT7() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("8", "SomeoneElse", 117, "someoneelse@gmail.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT8() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("9", "SomeoneElse", 118, "someoneelse@gmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT9() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("10", "SomeoneElse", 210, "someoneelse@gmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT10() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("11", "SomeoneElse", 211, "someoneelse@gmail.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT11() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("12", "SomeoneElse", 936, "someoneelse@gmail.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT12() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("13", "SomeoneElse", 937, "someoneelse@gmail.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT13() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("14", "SomeoneElse", 938, "someoneelse@gmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT14() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("someId", "SomeoneElse", 936, "someoneelse@gmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT15() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("15", "SomeoneElse", 936, "someoneelse@gmailcom", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT16() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("16", "SomeoneElse", 936, "someoneelsegmail.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT17() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("17", "SomeoneElse", 936, "someoneelsegmailcom", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT18() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("18", "SomeoneElse", 936, "", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT19() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("19", ".-, .,'", 936, "s@e.com", "prof");

        assertEquals(student, stsrv.add(student));
    }

    @Test
    public void blackboxT20() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("19", ".-, .,'1", 936, "s@e.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void blackboxT21() throws ValidationException {
        StudentValidator vs=new StudentValidator();
        StudentRepo strepo=new StudentRepo(vs, "StudentiXL.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("19", ".-, .,'!", 936, "s@e.com", "prof");

        try {
            assertNull(stsrv.add(student));
        } catch (ValidationException e) {
            assertTrue(true);
        }
    }



    @Test
    public void testAddAssignmentWhiteBox() throws ValidationException {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "teme.xml");
        ServiceTeme st = new ServiceTeme(tr);
        Teme tema = new Teme(1, "O tema", 10, 15);
        try {
            st.add(tema);
        } catch (ValidationException e) {
            assertEquals("\nDeadline invalid", e.getMessage());
        }
    }

    @Test
    public void testAddAssignmentWhiteBox1() throws ValidationException {
        TemeValidator tv = new TemeValidator();
        TemeRepo trepo = new TemeRepo(tv, "teme.xml");
        ServiceTeme tsrv = new ServiceTeme(trepo);
        Teme teme = new Teme(1, "wtf", 15, -1);

        try {
            tsrv.add(teme);
        } catch(ValidationException e) {
            assertEquals("\nDeadline invalid\nSaptamana in care tema a fost primita este invalida", e.getMessage());
        }
    }

}
