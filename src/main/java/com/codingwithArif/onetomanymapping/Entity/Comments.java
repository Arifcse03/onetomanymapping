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
    @Column
    private String text;
    @Column
    private  Long pc_fid;

    public Long getPc_fid() {
        return pc_fid;
    }

    public void setPc_fid(Long pc_fid) {
        this.pc_fid = pc_fid;
    }

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
