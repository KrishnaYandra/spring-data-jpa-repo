package com.krishna.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krishna.spring.data.jpa.tutorial.entity.Course;
import com.krishna.spring.data.jpa.tutorial.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
				.title("Csharp")
				.credit(5).build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.javatpoint.com")
				.course(course)
				.build();
		
		courseMaterialRepository.save(courseMaterial);
	}
	
	@Test
	public void printCourseMaterials() {
		List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
		System.out.println(courseMaterials);
	}

}
