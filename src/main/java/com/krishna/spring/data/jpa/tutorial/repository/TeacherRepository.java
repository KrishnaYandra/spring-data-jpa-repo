package com.krishna.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.spring.data.jpa.tutorial.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
