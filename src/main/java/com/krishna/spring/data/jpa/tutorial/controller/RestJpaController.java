package com.krishna.spring.data.jpa.tutorial.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.spring.data.jpa.tutorial.entity.Course;
import com.krishna.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.krishna.spring.data.jpa.tutorial.entity.Student;
import com.krishna.spring.data.jpa.tutorial.mapper.StudentMapper;
import com.krishna.spring.data.jpa.tutorial.repository.CourseMaterialRepository;
import com.krishna.spring.data.jpa.tutorial.repository.CourseRepository;
import com.krishna.spring.data.jpa.tutorial.repository.StudentRepository;
import com.krishna.spring.data.jpa.tutorial.repository.TeacherRepository;
import com.krishna.spring.data.jpa.tutorial.vo.CourseMaterialVO;
import com.krishna.spring.data.jpa.tutorial.vo.CourseVO;
import com.krishna.spring.data.jpa.tutorial.vo.GuardianVO;
import com.krishna.spring.data.jpa.tutorial.vo.StudentVO;

@RestController
@RequestMapping("/operations")
@Transactional
public class RestJpaController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
	
	

	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String hellowWorld() {
		return "Hello World";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getStudent/{studentName}")
	public List<StudentVO> getStudentByName(@PathVariable String studentName) {
		List<Student> studentList = studentRepository.findByFirstName(studentName);
		List<StudentVO> studentVOs = new ArrayList<>();
		studentVOs.add(StudentVO.builder().studentId(studentList.get(0).getStudentId())
				.firstName(studentList.get(0).getFirstName()).lastName(studentList.get(0).getLastName())
				.emailId(studentList.get(0).getEmailId())
				.guardian(new GuardianVO(studentList.get(0).getGuardian().getName(),
						studentList.get(0).getGuardian().getMobile(), studentList.get(0).getGuardian().getEmail()))
				.build());
		return studentVOs;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getCourse/{id}")
	public CourseVO getCourseById(@PathVariable Long id) {
		Optional<Course> course = courseRepository.findById(id);
		CourseVO courseVO = new CourseVO(course.get().getCourseId(), course.get().getTitle(), course.get().getCredit(), null, null);
		return courseVO;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getCourseMaterial/{id}")
	public CourseMaterialVO getCourseMaterialById(@PathVariable Long id) {
		List<CourseMaterial> courseMaterialList = courseMaterialRepository.findByCourseMaterialId(id);
		CourseMaterialVO courseMaterialVO = new CourseMaterialVO(courseMaterialList.get(0).getCourseMaterialId(),courseMaterialList.get(0).getUrl(),null);
		return courseMaterialVO;
	}
}
