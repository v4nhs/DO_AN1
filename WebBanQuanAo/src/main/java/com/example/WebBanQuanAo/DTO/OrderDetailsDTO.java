package com.example.WebBanQuanAo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    private int quantity;
    private float totalPrice;
    private String productName;
    private float productPrice;
    private String sizeName;
    private String colorName;

}
