package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.DTO.ProductRequest;
import com.example.WebBanQuanAo.Entity.ImageProduct;
import com.example.WebBanQuanAo.Entity.Product;
import com.example.WebBanQuanAo.Entity.ProductDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    ResponseEntity<?> getByID(int IDProduct);
    ResponseEntity<?> getByIDCate(int IDCategory);
    String uploadImageProduct(int idProduct, MultipartFile image) throws IOException;

    String insertImageProduct(int idProduct, MultipartFile image) throws IOException;

    String insertChooseSize(int idProduct, MultipartFile image) throws IOException;

    String insertProduct(ProductRequest productRequest);

    List<ProductDetails> getDetailProductByID(int idProduct);

    List<ImageProduct> getListImageProduct(int idProduct);

    String insertSizeAndColorProduct(int idProduct, int idSize, int idColor, int productRemain);

    String updateProduct(ProductRequest productRequest, int idProduct);
}
