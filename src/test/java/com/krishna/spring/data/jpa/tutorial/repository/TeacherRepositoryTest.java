package com.krishna.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krishna.spring.data.jpa.tutorial.entity.Course;
import com.krishna.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		Course courseDBA = Course.builder()
				.title("DSA")
				.credit(6).build();
		
		Course courseJava = Course.builder()
				.title("Java")
				.credit(8).build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Qutub")
				.lastName("Khan").build();
		
		teacherRepository.save(teacher);
	}
	
	@Test
	public void printAll() {
		List<Teacher> teachers = teacherRepository.findAll();
		for(Teacher teacher : teachers) {
			for(Course course:teacher.getCourses()) {
				System.out.println(teacher.getFirstName()+"-"+teacher.getLastName());
				System.out.println(course.getCourseId()+"-"+course.getTitle());
			}
		}
	}

}
