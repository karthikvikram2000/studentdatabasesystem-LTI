package dao;

import java.util.List;
import java.util.Map;

import model.Course;
import model.Registration;
import model.Student;

public interface StudentDao {
	String addNewStudent(Student student);
	void updateStudentProfile(Student student);
	Student findStudentByRollNo(int rollNo);
	List<Student> viewAllStudents();
	
	String addNewCourse(Course course);
	List<Course> viewAllCourses();
	Course findCourseById(int courseId);
	
	Map<Student, Course> viewAllRegistrations();
	void registration(Student student, Course course);
	String registrationDb(Registration registration);
	
}
