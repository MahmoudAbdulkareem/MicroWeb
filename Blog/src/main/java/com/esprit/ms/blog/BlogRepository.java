package com.esprit.ms.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Method to find blogs by category
    List<Blog> findByCategory(Category category);

    // Method to find blogs by title (for advanced search by title)
    List<Blog> findByTitleContainingIgnoreCase(String title);
}
