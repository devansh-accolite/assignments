import model.Course;
import model.Student;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Student student = new Student();
//        student.setStudentName("ABC");
//        student.setStudentAge(25);
//
//        session.save(student);
//
//        student = new Student();
//        student.setStudentName("DEF");
//        student.setStudentAge(20);
//
//        session.save(student);
//
//        student = new Student();
//        student.setStudentName("GHI");
//        student.setStudentAge(21);
//
//        session.save(student);
//
//        Course course = new Course();
//        course.setCourseName("Hibernate");
//        course.setStudentId(1);
//
//        session.save(course);
//
//        course = new Course();
//        course.setCourseName("Spring");
//        course.setStudentId(3);
//
//        session.save(course);

        Criteria studentCriteria = session.createCriteria(Student.class);
        System.out.println("\nOUTPUT ALL STUDENTS");
        for(Object o: studentCriteria.list()) {
            Student s = (Student) o;
            System.out.println(s.getStudentId() + "\t" + s.getStudentName() + "\t" + s.getStudentAge());
        }

        Criteria courseCriteria = session.createCriteria(Course.class);
        System.out.println("\nOUTPUT ALL COURSES");
        for(Object o: courseCriteria.list()) {
            Course c = (Course) o;
            System.out.println(c.getCourseId() + "\t" + c.getCourseName() + "\t" + c.getStudentId());
        }

        Criteria studentCriteria1 = session.createCriteria(Student.class);
        studentCriteria1.add(Restrictions.ge("studentAge", 21));
        List<Student> studentList = studentCriteria1.list();
        System.out.println("\nOUTPUT OF AGE RESTRICTION");
        for(Student s: studentList) {
            System.out.println(s.getStudentId() + "\t" + s.getStudentName() + "\t" + s.getStudentAge());
        }

        Criteria courseCriteria1 = session.createCriteria(Course.class);
        courseCriteria1.add(Restrictions.disjunction().add(Restrictions.eq("courseId", 4)).add(
                Restrictions.eq("courseName", "Spring")));
        List<Course> courseList = courseCriteria1.list();
        System.out.println("\nOUTPUT OF DISJUNCTION");
        for(Course c: courseList) {
            System.out.println(c.getCourseId() + "\t" + c.getCourseName() + "\t" + c.getStudentId());
        }

        Criteria studentCriteria2 = session.createCriteria(Student.class);
        List<Student> studentList1 = studentCriteria2.list();
        System.out.println("\nOUTPUT OF JOIN");
        for (Student s : studentList1) {
            System.out.println(s.getStudentName() + "|" + s.getStudentAge() + "|" + s.getStudentId()
                    + "|" + (!s.getCourses().isEmpty() ? s.getCourses().get(0).getCourseName() : ""));
        }

        session.getTransaction().commit();
    }
}
