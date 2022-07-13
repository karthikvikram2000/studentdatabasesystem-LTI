package controller;

import java.util.List;
import java.util.Map;

import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import exception.PhoneException;
import model.Course;
import model.Registration;
import model.Student;

public class StudentController {

	StudentDao dao = new StudentDaoImplDatabase();

	public String addNewStudent(Student student) {
		// TODO Auto-generated method stub
		if (student.getPhoneNo().length() != 10) {
			try {
				throw new PhoneException("Invalid Phone Number");
			} catch (PhoneException e) {
				return e.getMessage();
			}
		}
		dao.addNewStudent(student);
		return "New student added successfully";
	}

	public void updateStudentProfile(Student student) {
		// TODO Auto-generated method stub

	}

	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		return dao.findStudentByRollNo(rollNo);
	}

	public List<Student> viewAllStudents() {
		// TODO Auto-generated method stub
		return dao.viewAllStudents();
	}

	public String addNewCourse(Course course) {
		// TODO Auto-generated method stub
		return dao.addNewCourse(course);
	}

	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	public Course findCourseById(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Student, Course> viewAllRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	public void registration(Student student, Course course) {
		// TODO Auto-generated method stub

	}

	public String registrationDb(Registration registration) {
		String message = "";
		Student student = dao.findStudentByRollNo(registration.getRollNo());
		Course course = dao.findCourseById(registration.getCourseId());
		if (student != null) {
			if (course != null) {
				if (course.getEligibility().equals(student.getQualification())) {
					message = dao.registrationDb(registration);
				} else {
					message = "You are not eligible";
				}
			} else {
				message = "Course not found";
			}
		} else {
			message = "Student not available";
		}
		return message;
	}
}
