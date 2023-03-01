package com.codingwithArif.onetomanymapping.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "xx_comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xx_comments_s")
    @SequenceGenerator(name = "xx_comments_s", sequenceName = "xx_comments_s", allocationSize = 1)
    private long id;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Comments() {

    }
    public Comments( String text) {
        super();
        this.text = text;
    }
}
