package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Sale;
import com.example.WebBanQuanAo.Repository.SaleRespository;
import com.example.WebBanQuanAo.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRespository saleRespository;
    @Override
    public List<Sale> getAllSale() {
        return saleRespository.findAll();
    }

    @Override
    public String insertSale(Sale sale) {
        saleRespository.save(sale);
        return "Thêm thành công";
    }

    @Override
    public String updateSale(Sale sale) {
        Sale getSale = saleRespository.findById(sale.getIdSale()).get();
        if(getSale != null){
            getSale.setNameSale(sale.getNameSale());
            getSale.setPercent(sale.getPercent());
            getSale.setStartDate(sale.getStartDate());
            getSale.setEndDate(sale.getEndDate());
            saleRespository.save(getSale);
            return "Sửa thành công";
        }else{
            return "Không tìm thấy";
        }
    }

    @Override
    public String deleteSale(int idSale) {
        Sale getSale = saleRespository.findById(idSale).get();
        if(getSale != null){
            saleRespository.delete(getSale);
            return "Xóa thành công";
        }else{
            return "Không tìm thấy";
        }
    }
}