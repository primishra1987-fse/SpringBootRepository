package com.example.springbootrestProgram.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Repository
@Entity
@Table(name="subject")
public class Subject {


	@Id
	@Column(name = "subjectId")
	private long subjectID;
	
	@Column(name = "title")
	private String subTitle;
	
	@Column(name = "duration_hours")
	private int durationHours;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval= true, mappedBy="subjectID" , fetch=FetchType.EAGER)
	private Set<Books> references =new HashSet<Books>();

	public long getSubjectID() {
		return subjectID;
	}
	
	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}


	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	

	public int getDurationHours() {
		return durationHours;
	}

	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}

	public Set<Books> getReferences() {
		return references;
	}

	public void setReferences(Set<Books> references) {
		this.references = references;
	}

}
