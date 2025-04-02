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

    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.addBlog(blog));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return ResponseEntity.of(blogService.getBlogById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog updatedBlog) {
        return ResponseEntity.of(blogService.updateBlog(id, updatedBlog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.deleteBlog(id));
    }
}
