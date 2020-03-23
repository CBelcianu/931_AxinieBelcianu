package LabAssiAsseProjectV04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Domain.Student;
import Domain.Teme;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceStudent;
import Service.ServiceTeme;
import Validator.StudentValidator;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
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
        Teme teme = new Teme(1, "wtf", 15, 4);

        try {
            tsrv.add(teme);
        } catch(ValidationException e) {
            assertEquals("\nSaptama perdarii invalida", e.getMessage());
        }
    }

}
