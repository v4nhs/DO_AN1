package com.example.WebBanQuanAo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class    ProductRequest {
    private String productName;
    private String productDes;
    private float importPrice;
    private float exportPrice;
    private int idSale;
    private int idCategoty;
}
