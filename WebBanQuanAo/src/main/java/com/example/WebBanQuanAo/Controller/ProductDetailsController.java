package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.DTO.ProductDetailsRequest;
import com.example.WebBanQuanAo.Entity.ProductDetails;
import com.example.WebBanQuanAo.Service.ProductDetailService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ProductDetailsController {
    @Autowired
    private ProductDetailService productDetailService;
    @GetMapping("/getProductDetails")
    public List<ProductDetails> getAllProductDetails(){
        return productDetailService.getProductDetailsWithColorAndSize();
    }
    @PostMapping("/updateProductDetails/{IDProductDetails}")
    public String insertSizeAndColorProduct(@RequestBody ProductDetailsRequest productDetailsRequest, @PathVariable int IDProductDetails){
        return productDetailService.updateSizeAndColorProduct(productDetailsRequest.getIdProduct(), productDetailsRequest.getIdSize(),
                productDetailsRequest.getIdColor(), productDetailsRequest.getProductRemain(), IDProductDetails);
    }
    @DeleteMapping("/deleteProductDetails/{IDProductDetails}")
    public String deleteProductDetails(@PathVariable int IDProductDetails){
        return productDetailService.deleteProductDetails(IDProductDetails);
    }
}
