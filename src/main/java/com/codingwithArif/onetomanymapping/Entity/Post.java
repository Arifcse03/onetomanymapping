package com.codingwithArif.onetomanymapping.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity


@Table(name = "XX_POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xx_posts_s")
    @SequenceGenerator(name = "xx_posts_s", sequenceName = "xx_posts_s", allocationSize = 1)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid", referencedColumnName = "id")
    List<Comments> comments = new ArrayList<>();


    public Post() {

    }

    public Post(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
