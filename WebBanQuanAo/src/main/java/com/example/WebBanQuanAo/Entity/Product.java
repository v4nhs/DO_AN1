package com.example.WebBanQuanAo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int idProduct;
    private String productName;
    private String productDes;
    private Float importPrice;
    private Float exportPrice;
    private String imageMain;
    private String choosingSize;
    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "id_categories")
    private Category category;

}
