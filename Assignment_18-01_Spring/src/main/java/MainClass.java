import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.spring.dao.StudentDao;
import com.au.spring.model.Student;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		StudentDao studentDao = classPathXmlApplicationContext.getBean(StudentDao.class);
		
		Student student = new Student();
		student.setStudent_id(7);
		student.setStudent_name("STU");
		
		studentDao.saveStudent(student);
		
		for(Student s: studentDao.getFiveStudents()) {
			System.out.println(s);
		}
		
		for(Student s: studentDao.getAllStudents()) {
			System.out.println(s);
		}
		
		classPathXmlApplicationContext.close();
	}
}
