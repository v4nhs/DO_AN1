package com.example.WebBanQuanAo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDetailsDTO {
    private int idProduct;
    private int idSize;
    private int idColor;
    private int quantity;
    private float totalPrice2;
}
