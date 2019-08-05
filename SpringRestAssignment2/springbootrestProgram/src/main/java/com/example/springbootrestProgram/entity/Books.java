package com.example.springbootrestProgram.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Repository
@Entity
@Table(name="books")
public class Books{

	@Id
	@Column(name = "book_id")
	private long bookId;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private double price;

	@Column(name = "volume")
	private int volume;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "publish_date")
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date publishDate;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	@JsonBackReference
	private Subject subjectID;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	
	public Subject getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Subject subjectID) {
		this.subjectID = subjectID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	
}
