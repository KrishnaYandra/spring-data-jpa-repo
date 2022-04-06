package com.krishna.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krishna.spring.data.jpa.tutorial.entity.Course;
import com.krishna.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourse() {
		List<Course> courses = courseRepository.findAll();
		System.out.println(courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		 Teacher teacher = Teacher.builder()
				 .firstName("priyanka")
				 .lastName("singh")
				 .build();
		 
		 Course course = Course.builder()
				 .title("Python")
				 .credit(5)
				 .teacher(teacher)
				 .build();
		 
		 courseRepository.save(course);
	}

}
