package com.krishna.spring.data.jpa.tutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.krishna.spring.data.jpa.tutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByFirstName(String firstName);

	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardianName(String guardianName);

	List<Student> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("select s from Student s where s.emailId= ?1")
	Student getStudentByEmailAddress(String emailId);

	@Query("select s.firstName from Student s where s.emailId= ?1")
	String getStudentFirstNameByEmailAddress(String emailId);

	@Query(value = "select * from tbl_student s where s.email_address= ?1", 
			nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailId);

	@Query(value="select * from tbl_student s where s.email_address= :emailId",
			nativeQuery = true)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(value="update tbl_student s set s.first_name = ?1 where s.email_address= ?2",
	nativeQuery = true)
	int updateStudentNameByEmailId(String firstName, String emailId);

}
