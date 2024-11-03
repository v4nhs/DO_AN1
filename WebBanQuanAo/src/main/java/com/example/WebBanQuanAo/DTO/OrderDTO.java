package com.example.WebBanQuanAo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Date orderAt;
    private int idOrder;
    private float totalPrice;
    private int totalItem;
    private float totalDiscount;
    private float totalFinal;
    private String orderType;
    private String statusOrder;
    private String statusPayment;
    private List<OrderDetailsDTO> orderDetails;
}

