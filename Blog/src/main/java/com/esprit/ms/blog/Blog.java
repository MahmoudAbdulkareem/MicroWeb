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
	private String author; // Display name
	private Long authorId; // ID of the author in UserService

	@Enumerated(EnumType.STRING) // Ensure category is stored as a string in the DB
	private Category category;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	public Blog() {}

	public Blog(String title, String content, String author, Category category, Long authorId) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.category = category;
		this.authorId = authorId;
	}

	// Getters and Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public Category getCategory() { return category; }
	public void setCategory(Category category) { this.category = category; }
	public Date getCreatedAt() { return createdAt; }
	public Long getAuthorId() { return authorId; }
	public void setAuthorId(Long authorId) { this.authorId = authorId; }
}
