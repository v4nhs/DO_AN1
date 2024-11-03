package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.ProductDetails;
import com.example.WebBanQuanAo.Repository.ProductDetailsRespository;
import com.example.WebBanQuanAo.Service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDetailsImpl implements ProductDetailService {
    @Autowired
    private ProductDetailsRespository productDetailsRespository;

    @Override
    public List<ProductDetails> getProductDetailsWithColorAndSize() {
       return productDetailsRespository.findAll();
    }

    @Override
    public String updateSizeAndColorProduct(int idProduct, int idSize, int idColor, int productRemain, int idProductDetails) {
         productDetailsRespository.updateSizeAndColorProduct(idProduct, idSize, idColor, productRemain, idProductDetails);
         return "Success";
    }

    @Override
    public String deleteProductDetails(int idProductDetails) {
        Optional<ProductDetails> productDetails = productDetailsRespository.findById(idProductDetails);
        if(productDetails.isPresent()){
            ProductDetails delObj = productDetails.get();
            productDetailsRespository.delete(delObj);
            return "Xóa thành công";
        }else{
            return "Không tìm thấy";
        }
    }
}
