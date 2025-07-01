package com.pro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 2000)
	private String title;
	
	@Column(length = 10000)
	private String description;
	
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Notes [id=" + id + ", title=" + title + ", description=" + description + ", user=" + user + "]";
	}
	
	
	
	
}
