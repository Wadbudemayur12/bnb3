package com.bnb3.controlloer;

import com.bnb3.entity.Comment;
import com.bnb3.entity.Post;
import com.bnb3.repository.CommentRepository;
import com.bnb3.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comment")
// TODO: Implement comment CRUD operations here.
public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
@PostMapping
    public String getComment(@RequestBody Comment comment, @RequestParam long postId) {
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        commentRepository.save(comment);
        return "Comment saved successfully.";
    }

}
