package com.krishna.spring.data.jpa.tutorial.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseVO {

	private Long courseId;
	private String title;
	private Integer credit;
	private CourseMaterialVO courseMaterialVO;
	private TeacherVO teacherVO;
}
