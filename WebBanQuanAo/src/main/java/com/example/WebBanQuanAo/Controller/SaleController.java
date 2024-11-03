package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.Entity.Sale;
import com.example.WebBanQuanAo.Service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class SaleController {
    @Autowired
    private SaleService saleService;
    @GetMapping("/getAllSale")
    public List<Sale> getAllSale(){
        return saleService.getAllSale();
    }

    @PostMapping("/insertSale")
    public String insertSale(@RequestBody Sale sale){
        return saleService.insertSale(sale);
    }

    @PutMapping("/updateSale")
    public String updateSale(@RequestBody Sale sale){
        return saleService.updateSale(sale);
    }

    @DeleteMapping("/deleteSale/{IDSale}")
    public String deleteSale(@PathVariable int IDSale){
        return saleService.deleteSale(IDSale);
    }
}
