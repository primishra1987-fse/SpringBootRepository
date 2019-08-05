package com.example.springbootrestProgram.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springbootrestProgram.entity.Subject;



public interface SubjectDao extends JpaRepository<Subject, Long>{

	
		@Modifying
	    @Transactional
	    @Query("delete from Subject u where u.id = ?1")
	    void deleteSubjectByID(long id);
		
		@Transactional
	    @Query("select u from Subject u where u.subTitle = ?1")
		public List<Subject> findByTitle(@Param("subTitle") String subTitle);
	    
		
		
	    @Transactional
	    @Query("select u from Subject u where u.durationHours = ?1")
	    public List<Subject> findByDuration(@Param("durationHours") int durationHours);
	    

	 
}
