package com.krishna.spring.data.jpa.tutorial.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuardianVO {
	private String name;
	private String email;
	private String mobile;
	
}
