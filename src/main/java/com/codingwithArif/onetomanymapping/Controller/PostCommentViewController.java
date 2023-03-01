package com.codingwithArif.onetomanymapping.Controller;

import com.codingwithArif.onetomanymapping.Entity.Comments;
import com.codingwithArif.onetomanymapping.Entity.Post;
import com.codingwithArif.onetomanymapping.Repo.CommentRepository;
import com.codingwithArif.onetomanymapping.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PostCommentViewController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @GetMapping("/view/{id}")
//    @PathVariable Long postId,
    public String viewPost(@PathVariable Long id, Model model) {
        String sql = "SELECT p.TITLE, p.DESCRIPTION, c.TEXT FROM XX_POSTS p \n" +
                "             LEFT JOIN XX_COMMENTS c ON p.ID = c.PC_FID \n" +
                "             WHERE p.id = ?";

System.out.println("____________________id is : "+sql);
        List<Object[]> rows = jdbcTemplate.query(sql, new Object[] { id }, new RowMapper<Object[]>() {
            @Override
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException, SQLException {
                return new Object[] { rs.getString("TITLE"), rs.getString("DESCRIPTION"), rs.getString("TEXT") };
            }
        });

        if (rows.isEmpty()) {
            model.addAttribute("errorMessage", "No post found with ID " + id);
        } else {
            String title = (String) rows.get(0)[0];
            String description = (String) rows.get(0)[1];
            List<String> comments = new ArrayList<>();
            for (Object[] row : rows) {
                String comment = (String) row[2];
                if (comment != null) {
                    comments.add(comment);
                }
            }
            model.addAttribute("title", title);
            model.addAttribute("description", description);
            model.addAttribute("comments", comments);
        }

        return "view";
    }

}
