package com.krishna.spring.data.jpa.tutorial.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterialVO {

	private Long courseMaterialId;
	private String url;
	private CourseVO courseVO;
}
