package LabAssiAsseProjectV04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Domain.Student;
import Repository.StudentRepo;
import Service.ServiceStudent;
import Validator.StudentValidator;
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
        StudentRepo strepo=new StudentRepo(vs, "StudentiXML.xml");
        ServiceStudent stsrv=new ServiceStudent(strepo);
        Student student = new Student("1", "Axinie", 931, "axiniuc@gmail.com", "prof");

        stsrv.add(student);
        assertEquals(931, stsrv.find("1").getGrupa());
        assertEquals(1, stsrv.size());
    }

}
