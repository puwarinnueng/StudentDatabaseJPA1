/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student emp1 = new Student(1, "John", 12345.0);
       Student emp2 = new Student(2, "Marry", 45678.0);
       StudentTable.insertStudent(emp1);
       StudentTable.insertStudent(emp2);
       //Student emp;
       //emp = StudentTable.findStudentById(1);
       //if (emp != null) {
       //    emp.setName("Jack");
           //StudentTable.removeStudent(emp);
       //    StudentTable.updateStudent(emp);
       //}
       //List<Student> empList = StudentTable.findStudentByName("Marry"); 
       List<Student> empList = StudentTable.findAllStudent();
       printAllStudent(empList);
    }
    public static void printAllStudent(List<Student> StudentList) {
        for(Student emp : StudentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa() + " ");
       }
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

   
   
    
}
