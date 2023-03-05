package com.codingwithArif.onetomanymapping.Controller;

import com.codingwithArif.onetomanymapping.Entity.Comments;
import com.codingwithArif.onetomanymapping.Entity.Post;
import com.codingwithArif.onetomanymapping.Repo.CommentRepository;
import com.codingwithArif.onetomanymapping.Repo.PostRepository;
import com.codingwithArif.onetomanymapping.Service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class PostAddController {
    @Autowired
    PostCommentService postCommentService;
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
    @GetMapping("/posts/{id}")
    public String showPostAndCommentList(@PathVariable Long id, Model model) {
        List<Map<String, Object>>  queryResultList = postCommentService.executeRawQuery(id);
        model.addAttribute("queryResultList", queryResultList);
        return "commnets-by-post";
    }
    @PostMapping("/add-post")
    public String processAddPostForm(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/";
    }

    @PostMapping("/addNewComment}")
    public String changePname(@RequestParam("id") Long id,
                              @RequestParam("newPcomment") String comment)
    {
        postCommentService.addNewProduct(id, comment);
        return "redirect:/posts/"+id;
    }
}
