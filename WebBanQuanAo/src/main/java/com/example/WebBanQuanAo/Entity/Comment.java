package com.example.WebBanQuanAo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int idComment;
    private String content;
    private Date createAt;
    private Date updateAt;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
