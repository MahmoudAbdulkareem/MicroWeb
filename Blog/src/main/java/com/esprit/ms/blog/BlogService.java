    package com.esprit.ms.blog;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;
    import org.springframework.web.bind.annotation.CrossOrigin;

    import java.util.List;
    import java.util.Optional;

    @Service
    @CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular frontend

    public class BlogService {

        @Autowired
        private BlogRepository blogRepository;

        public Blog addBlog(Blog blog) {

            return blogRepository.save(blog);
        }

        public List<Blog> getAllBlogs() {
            return blogRepository.findAll();
        }

        public Optional<Blog> getBlogById(Long id) {
            if (id == null) {
                throw new IllegalArgumentException("The given ID must not be null");
            }
            return Optional.ofNullable(blogRepository.findById(id)
                    .orElseThrow(() -> new BlogNotFoundException("Blog with ID " + id + " not found.")));
        }

        public Optional<Blog> updateBlog(Long id, Blog updatedBlog) {
            if (id == null) {
                throw new IllegalArgumentException("The given ID must not be null");
            }
            return blogRepository.findById(id)
                    .map(blog -> {
                        blog.setTitle(updatedBlog.getTitle());
                        blog.setContent(updatedBlog.getContent());
                        blog.setAuthor(updatedBlog.getAuthor());
                        return blogRepository.save(blog);
                    });
        }

        public String deleteBlog(Long id) {
            if (id == null) {
                throw new IllegalArgumentException("The given ID must not be null");
            }
            if (!blogRepository.existsById(id)) {
                throw new BlogNotFoundException("Cannot delete. Blog with ID " + id + " not found.");
            }
            blogRepository.deleteById(id);
            return "Blog deleted";
        }
    }
