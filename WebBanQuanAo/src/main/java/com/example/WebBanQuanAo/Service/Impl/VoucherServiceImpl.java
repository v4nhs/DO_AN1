package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Voucher;
import com.example.WebBanQuanAo.Repository.VoucherRespository;
import com.example.WebBanQuanAo.Service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRespository voucherRespository;
    @Override
    public ResponseEntity<?> applyVoucher(String code, float totalPrice) {
        Voucher voucher = voucherRespository.getByCode(code);
        if(voucher != null){
            if (voucherRespository.checkVoucher(code, totalPrice) != 0 ) {
                float discount = totalPrice * voucher.getPercent() / 100;
                return new ResponseEntity<>(discount, HttpStatus.OK);
            } else {
                // Nếu mã voucher không hợp lệ hoặc giá trị đơn hàng không đủ lớn
                StringBuilder errorMessageBuilder = new StringBuilder("Lỗi: ");
                if (totalPrice <= voucher.getTotalPriceApply()) {
                    errorMessageBuilder.append(String.format("Giá trị đơn hàng phải lớn hơn %.2f. ", voucher.getTotalPriceApply()));
                }
                if (voucher.getQuantity() <= 0) {
                    errorMessageBuilder.append("Số lượng voucher đã hết. ");
                }
                Date currentDate = new Date();
                Date startDate = voucher.getStartDate();
                Date endDate = voucher.getEndDate();
                // Kiểm tra thời gian sử dụng của voucher
                if (currentDate.before(startDate) || currentDate.after(endDate)) {
                    errorMessageBuilder.append("Thời gian sử dụng voucher không hợp lệ. ");
                }

                return new ResponseEntity<>(errorMessageBuilder.toString(), HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>("Mã code không hợp lệ", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String insertVoucher(Voucher voucher) {
        voucherRespository.save(voucher);
        return "Thêm thành công";
    }

    @Override
    public String updateVoucher(Voucher voucher) {
        Voucher getVoucher = voucherRespository.findById(voucher.getIdVoucher()).get();
        if(getVoucher != null){
            getVoucher.setNameVoucher(voucher.getNameVoucher());
            getVoucher.setCode(voucher.getCode());
            getVoucher.setPercent(voucher.getPercent());
            getVoucher.setQuantity(voucher.getQuantity());
            getVoucher.setEndDate(voucher.getEndDate());
            getVoucher.setStartDate(voucher.getStartDate());
            getVoucher.setTotalPriceApply(voucher.getTotalPriceApply());
            voucherRespository.save(getVoucher);
            return "Sửa thành công";
        }else{
            return "Không tìm thấy voucher";
        }
    }

    @Override
    public String deleteVoucher(int idVoucher) {
        Voucher getVoucher = voucherRespository.findById(idVoucher).get();
        if(getVoucher != null){
            voucherRespository.delete(getVoucher);
            return "Xóa thành công";
        }else{
            return "Không tìm thấy voucher";
        }
    }

    @Override
    public List<Voucher> getAlLVoucher() {
        return voucherRespository.findAll();
    }
}