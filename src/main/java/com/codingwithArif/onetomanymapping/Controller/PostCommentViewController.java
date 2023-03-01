package com.codingwithArif.onetomanymapping.Controller;

import com.codingwithArif.onetomanymapping.Entity.Comments;
import com.codingwithArif.onetomanymapping.Entity.Post;
import com.codingwithArif.onetomanymapping.Repo.CommentRepository;
import com.codingwithArif.onetomanymapping.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostCommentViewController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @GetMapping("/view/{id}")
//    @PathVariable Long postId,
    public String viewPost(@PathVariable Long id, Model model) {
        Post post =  postRepository.findById(id).orElse(null);
        List<Comments> comments = commentRepository.findByPCFID(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "view";
    }

}
