package com.esprit.ms.blog;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String content;
	private String author;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	public Blog() {}

	public Blog(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public Date getCreatedAt() { return createdAt; }
}
