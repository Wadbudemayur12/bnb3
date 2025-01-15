package com.bnb3.controlloer;

import com.bnb3.entity.Comment;
import com.bnb3.entity.Post;
import com.bnb3.repository.CommentRepository;
import com.bnb3.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
   private PostRepository postRepository;
   private CommentRepository commentRepository;
   public PostController(PostRepository postRepository, CommentRepository commentRepository) {
      this.postRepository = postRepository;
      this.commentRepository = commentRepository;
   }
   @PostMapping
   public String getPost(@RequestBody Post post) {
       postRepository.save(post);
       return "record saved";
   }
   @DeleteMapping
   public String deletePost(){
       postRepository.deleteById(1l);
       return "record deleted";
   }
}
