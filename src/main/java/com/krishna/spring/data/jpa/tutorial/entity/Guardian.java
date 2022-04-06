package com.krishna.spring.data.jpa.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guardian {
	@Column(name="guardian_name")
	private String name;
	@Column(name="guardian_email")
	private String email;
	@Column(name="guardian_mobile")
	private String mobile;
	
}
