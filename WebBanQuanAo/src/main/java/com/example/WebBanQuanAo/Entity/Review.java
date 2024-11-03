package com.example.WebBanQuanAo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private int idReview;
    private String content;
    private int start;
    private Date createAt;
    private Date updateAt;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
