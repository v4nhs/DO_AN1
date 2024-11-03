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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;
    private Date orderAt;
    private String tenNguoiNhan;
    private String ghiChu;
    private String email;
    private String phone;
    private String diaChiNhanHang;
    private String thanhPho;
    private Float totalPrice;
    private int totalItem;
    private Float totalDiscount;
    private Float totalFinal;
    @ManyToOne()
    @JoinColumn(name = "id_profile")
    private Profile profile;
    private String statusOrder;
    private String orderType;
    private String statusPayment;
    @ManyToOne
    @JoinColumn(name = "id_voucher")
    private Voucher voucher;
}
