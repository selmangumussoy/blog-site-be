package com.example.blogsitebe.domain.platform.example.web;

import com.example.blogsitebe.domain.platform.example.impl.PostRepository;
import com.example.blogsitebe.domain.platform.example.impl.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5176") // Vue.js adresine izin ver
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // Tüm postları getir
    @GetMapping
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    // Yeni bir post oluştur
    @PostMapping
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }
}
