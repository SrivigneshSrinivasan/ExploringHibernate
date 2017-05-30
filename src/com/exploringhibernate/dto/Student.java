package com.exploringhibernate.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long studentId;
	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	private String studentName;
	@OneToOne(targetEntity = StudentAddress.class, cascade = CascadeType.ALL)
	private StudentAddress studentAddress;

	public Student() {
	}

	public Student(String studentName, StudentAddress studentAddress) {
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}

	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public StudentAddress getStudentStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}

}
