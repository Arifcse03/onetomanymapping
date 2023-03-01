package com.codingwithArif.onetomanymapping.Controller;

import com.codingwithArif.onetomanymapping.Entity.Comments;
import com.codingwithArif.onetomanymapping.Entity.Post;
import com.codingwithArif.onetomanymapping.Repo.CommentRepository;
import com.codingwithArif.onetomanymapping.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostAddController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @GetMapping("/add-post")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("comment", new Comments());
        return "add_post";
    }
    @GetMapping("/posts")
    public String showPostAndCommentList(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "post_comment_list";
    }

    @PostMapping("/add-post")
    public String processAddPostForm(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/";
    }

    @PostMapping("/add-comment")
    public String processAddCommentForm(@ModelAttribute Comments comment) {
        commentRepository.save(comment);
        return "redirect:/";
    }
}
