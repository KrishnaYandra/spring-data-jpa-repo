package com.krishna.spring.data.jpa.tutorial.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherVO {
	
	private Long teacherId;
	private String firstName;
	private String lastName;
	private List<CourseVO> courses;
}
