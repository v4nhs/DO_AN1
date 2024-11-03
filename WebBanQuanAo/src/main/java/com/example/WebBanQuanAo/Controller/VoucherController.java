package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.Entity.Voucher;
import com.example.WebBanQuanAo.Service.VoucherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class VoucherController {
    @Autowired
    public VoucherService voucherService;
    @PostMapping("/applyVoucher")
    public ResponseEntity<?> applyVoucher(@RequestParam("code") String code,
                                          @RequestParam("totalPrice") float totalPrice){
        return voucherService.applyVoucher(code, totalPrice);
    }
    @PostMapping("/insertVoucher")
    public String insertVoucher(@RequestBody Voucher voucher){
        return voucherService.insertVoucher(voucher);
    }
    @PutMapping("/updateVoucher")
    public String updateVoucher(@RequestBody Voucher voucher){
        return voucherService.updateVoucher(voucher);
    }
    @DeleteMapping("/deleteVoucher/{IDVoucher}")
    public String deleteVoucher(@PathVariable int IDVoucher){
        return voucherService.deleteVoucher(IDVoucher);
    }

    @GetMapping("/getAllVoucher")
    public List<Voucher> getAllVoucher(){
        return voucherService.getAlLVoucher();
    }
}
