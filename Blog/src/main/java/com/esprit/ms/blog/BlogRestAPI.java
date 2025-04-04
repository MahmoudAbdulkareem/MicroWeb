package com.esprit.ms.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Blogs")
public class BlogRestAPI {

    @Autowired
    private BlogService blogService;

    @PostMapping("/add")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        try {
            Blog createdBlog = blogService.addBlog(blog);
            return ResponseEntity.ok(createdBlog);
        } catch (BlogAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        try {
            return ResponseEntity.of(blogService.getBlogById(id));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // 400 Bad Request
        }
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        if (blogs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(blogs);  // 204 No Content
        }
        return ResponseEntity.ok(blogs);
    }


    // Get blogs by category (using the Category enum)
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Blog>> getBlogsByCategory(@PathVariable Category category) {
        List<Blog> blogs = blogService.getBlogsByCategory(category);
        if (blogs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(blogs);
        }
        return ResponseEntity.ok(blogs);
    }

    // Search blogs by title
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlogs(@RequestParam String keyword) {
        List<Blog> blogs = blogService.searchBlogs(keyword);
        if (blogs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(blogs);
        }
        return ResponseEntity.ok(blogs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog updatedBlog) {
        try {
            return ResponseEntity.of(blogService.updateBlog(id, updatedBlog));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // 400 Bad Request
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(blogService.deleteBlog(id));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID provided.");  // 400 Bad Request
        }
    }
}
