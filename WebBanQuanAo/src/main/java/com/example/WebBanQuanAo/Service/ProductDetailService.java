package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.ProductDetails;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetails> getProductDetailsWithColorAndSize();

    String updateSizeAndColorProduct(int idProduct, int idSize, int idColor, int productRemain, int idProductDetails);
    String deleteProductDetails(int idProductDetails);
}
