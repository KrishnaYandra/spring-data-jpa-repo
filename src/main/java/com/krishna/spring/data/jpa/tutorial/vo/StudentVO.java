package com.krishna.spring.data.jpa.tutorial.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {
	
	private Long studentId;
	private String firstName;
	private String lastName;
	private String emailId;
	private GuardianVO guardian;
	
}
