package com.example.WebBanQuanAo.DTO;

import com.example.WebBanQuanAo.Entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {
    private float totalPrice;
    private String tenNguoiNhan;
    private String ghiChu;
    private String email;
    private String phone;
    private String diaChiNhanHang;
    private String thanhPho;
    private int totalItem;
    private float totalDiscount;
    private float totalFinal;
    private int idProfile;
    private int idVoucher;
    private List<BillDetailsDTO> billDetailsDTOList;
    private List<Integer> listIDCart;
}
