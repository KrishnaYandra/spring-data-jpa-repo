package com.krishna.spring.data.jpa.tutorial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

	@Id
	@SequenceGenerator(
			name="course_sequence",
			sequenceName="course_sequence",
			allocationSize=1)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="course_sequence")
	private Long courseId;
	private String title;
	private Integer credit;
	
	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id",
			referencedColumnName = "teacherId")
	private Teacher teacher;
	
	@ManyToMany
	@JoinTable(
			joinColumns = @JoinColumn(
					name = "course_id",
					referencedColumnName = "courseId"),
			inverseJoinColumns = @JoinColumn(
					name = "student_Id",
					referencedColumnName = "studentId")
			)
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students == null) students = new ArrayList<>();
		students.add(student);
	}
}