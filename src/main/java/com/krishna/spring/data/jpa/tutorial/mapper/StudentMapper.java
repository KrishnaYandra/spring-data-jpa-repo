package com.krishna.spring.data.jpa.tutorial.mapper;

import org.mapstruct.Mapper;

import com.krishna.spring.data.jpa.tutorial.entity.Student;
import com.krishna.spring.data.jpa.tutorial.vo.StudentVO;

@Mapper
public interface StudentMapper {
	StudentVO studentToStudentVO(Student student);
}
