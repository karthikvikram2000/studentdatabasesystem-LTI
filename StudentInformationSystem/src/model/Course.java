package model;

public class Course {
	private int  courseId;
	private String courseName;
	private int durationInMonths;
	private double fee;
	private Qualification eligibility;
//	private static int courseIdGenerator = 100;
	public Course() {}
	public Course(String courseName, int duration, double fee, Qualification eligibility) {
		super();
//		this.courseId = ++courseIdGenerator;
		this.courseName = courseName;
		this.durationInMonths = duration;
		this.fee = fee;
		this.eligibility = eligibility;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int duration) {
		this.durationInMonths = duration;
	}
	public Qualification getEligibility() {
		return eligibility;
	}
	public void setEligibility(Qualification eligibility) {
		this.eligibility = eligibility;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
}
