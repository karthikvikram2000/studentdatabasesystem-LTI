package view;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dao.StudentDao;
import dao.StudentDaoImplInMemory;
import model.Course;
import model.Qualification;
import model.Student;

public class Main {
	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImplInMemory();
		
		Student student1 = new Student("John",LocalDate.of(2000, 10, 12),Qualification.Intermediate,"9895243221","john@lti.com","Mumbai");
		Student student2 = new Student("Peter",LocalDate.of(2000, 5, 17),Qualification.Master,"9895136871","peter@lti.com","Chennai");
		Student student3 = new Student("Mike",LocalDate.of(2000, 9, 30),Qualification.Graduate,"8952437221","mike@lti.com","Kolkata");
		Student student4 = new Student("Dustin",LocalDate.of(2000, 1, 26),Qualification.Intermediate,"9524346221","dustin@lti.com","Coimbatore");
		
		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		dao.addNewStudent(student4);
		
		//DAO method
		System.out.println("View all students: ");
		List<Student> students = dao.viewAllStudents();
		
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail()+" "+student.getPhoneNo()+" "+Student.getCollegeName());
		}
		
		Course course1 = new Course("Java",6,4000,Qualification.Graduate);
		Course course2 = new Course("Python",3,2000,Qualification.Graduate);
		Course course3 = new Course(".NET",5,3000,Qualification.Matric);
		Course course4 = new Course("Azure",8,7000,Qualification.Master);
		
		dao.addNewCourse(course1);
		dao.addNewCourse(course2);
		dao.addNewCourse(course3);
		dao.addNewCourse(course4);

		//DAO method
		System.out.println("View all courses: ");
		List<Course> courses = dao.viewAllCourses();
		
		Iterator<Course> iteratorCourse = courses.iterator();
		while(iteratorCourse.hasNext()) {
			Course course = iteratorCourse.next();
			System.out.println(course.getCourseId()+" "+course.getCourseName()+" "+course.getDurationInMonths()+" "+course.getFee()+" "+course.getEligibility());
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter student roll number and course applying for: ");
		int rollNo = sc.nextInt();
		int courseId = sc.nextInt();
		
		Student stud1 = dao.findStudentByRollNo(rollNo);
		Course c1 = dao.findCourseById(courseId);
		if(stud1!=null) {
			if(c1!=null) {
				dao.registration(stud1, c1);
				System.out.println("Registraion successful.");
			}
		}
		else {
			System.out.println("Student not found");
		}
		
		System.out.println("View all registrations: ");
		
		Map<Student, Course> registrations = dao.viewAllRegistrations();
		
		Set<Map.Entry<Student, Course>> regs = registrations.entrySet();
		for(Map.Entry<Student, Course> r: regs) {
			Student s = r.getKey();
			Course c = r.getValue();
			System.out.println(s.getRollNo()+" "+s.getName()+" "+c.getCourseId()+" "+c.getCourseName());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//DAO method
//		System.out.println("Enter rollNo: ");
//		int rollNo = sc.nextInt();
//		Student student = dao.findStudentByRollNo(rollNo);
//		if(student!=null) {
//			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail());
//		}
//		else {
//			System.out.println("Student not found.");
//		}
		
		//DAO method
//		System.out.println("Enter rollNo: ");
//		int rollNo = sc.nextInt();
//		Student student = dao.findStudentByRollNo(rollNo);
//		if(student!=null) {
//			System.out.println("Enter phoneNo: ");
//			String phoneNo = sc.next();
//			student.setPhoneNo(phoneNo);
//			dao.updateStudentProfile(student);
//			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail()+" "+student.getPhoneNo());
//		}
//		else {
//			System.out.println("Student not found.");
//		}
//		
//		iterator = students.iterator();
//		while(iterator.hasNext()) {
//			Student s = iterator.next();
//			System.out.println(s.getRollNo()+" "+s.getName()+" "+s.getEmail()+" "+s.getPhoneNo());
//		}
		
		
	}
}
