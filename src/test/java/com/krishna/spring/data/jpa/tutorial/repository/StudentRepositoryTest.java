package com.krishna.spring.data.jpa.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krishna.spring.data.jpa.tutorial.entity.Guardian;
import com.krishna.spring.data.jpa.tutorial.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Guardian guardian = Guardian.builder().name("ojha").email("ojha@gmail.com").mobile("1246546554").build();
		Student student = Student.builder().emailId("sohail@gmail.com").firstName("sohai").lastName("ahmed")
				.guardian(guardian)
//				.guardianEmail("nikhil")
//				.guardianName("nikhil@gmail.com")
//				.guardianMobile("9999999999")
				.build();

		studentRepository.save(student);
	}

	@Test
	public void printAllStudents() {
		List<Student> studetnList = studentRepository.findAll();
		System.out.println(studetnList);
	}

	@Test
	public void getStudent() {
		List<Student> studetnList = studentRepository.findByFirstName("shabbir");
		System.out.println(studetnList);
	}
	
	@Test
	public void printStudentNative() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("sohail@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void updateStudentFirstName() {
		int i = studentRepository.updateStudentNameByEmailId("sohail","sohail@gmail.com");
		System.out.println(i);
	}

}
