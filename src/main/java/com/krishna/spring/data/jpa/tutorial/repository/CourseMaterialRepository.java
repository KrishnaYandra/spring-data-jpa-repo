package com.krishna.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.spring.data.jpa.tutorial.entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
	List<CourseMaterial> findByCourseMaterialId(Long courseMaterialId);
}
