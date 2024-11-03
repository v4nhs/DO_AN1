package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getAllSale();
    String insertSale(Sale sale);
    String updateSale(Sale sale);
    String deleteSale(int idSale);
}
