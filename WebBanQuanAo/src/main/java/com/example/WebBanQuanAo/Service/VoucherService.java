package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.Voucher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VoucherService {
    ResponseEntity<?> applyVoucher(String code, float totalPrice);
    String insertVoucher(Voucher voucher);
    String updateVoucher(Voucher voucher);
    String deleteVoucher(int idVoucher);
    List<Voucher> getAlLVoucher();
}
