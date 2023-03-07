package com.codingwithArif.onetomanymapping.Service;

import com.codingwithArif.onetomanymapping.Entity.Comments;
import com.codingwithArif.onetomanymapping.Entity.Post;
import com.codingwithArif.onetomanymapping.Repo.CommentRepository;
import com.codingwithArif.onetomanymapping.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostCommentService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;


    private JdbcTemplate jdbcTemplate;

    public PostCommentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> executeRawQuery(Long id) {
        String sql = "SELECT   ID,TEXT,PC_FID FROM XX_comments WHERE PC_FID = "+ id +"order by id desc";
        List<Map<String, Object>> queryResultList = jdbcTemplate.queryForList(sql);
        return queryResultList;
    }
    public void addNewProduct(Long id ,String name)
    {
System.out.println("new product : --------"+id+"new comment : ----- "+name);
        Comments comments = new Comments();
        comments.setPc_fid(id);
        comments.setText(name);
        commentRepository.save(comments);
    }

    public  void  addNewPost (String title,String Des){

        Post post = new Post();
        post.setTitle(title);
        post.setDescription(Des);
        postRepository.save(post);
    }
    public void deleteCommentById(Long id)
    {
System.out.println(id);
        commentRepository.deleteById(id);
        System.out.println("done with delete");
    }
}
