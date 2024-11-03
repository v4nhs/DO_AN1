package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.DTO.ProductRequest;
import com.example.WebBanQuanAo.Entity.*;
import com.example.WebBanQuanAo.Repository.*;
import com.example.WebBanQuanAo.Service.CloundService;
import com.example.WebBanQuanAo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRespository productRespository;
    @Autowired
    private CloundService cloundService;
    @Autowired
    private SaleRespository saleRespository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageProductRespository imageProductRespository;
    @Autowired
    private ProductDetailsRespository productDetailsRespository;


    @Override
    public List<Product> getAllProduct() {
        return productRespository.findAll();
    }

    @Override
    public ResponseEntity<?> getByID(int IDProduct) {
        return new ResponseEntity<>(Map.of("message:", "Thành công", "data", productRespository.findById(IDProduct).get()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByIDCate(int IDCategory) {
        return new ResponseEntity<>(Map.of("message:", "Thành công", "data", productRespository.getByIDCate(IDCategory)), HttpStatus.OK);
    }

    @Override
    public String uploadImageProduct(int idProduct, MultipartFile image) throws IOException {
        Product product = productRespository.findById(idProduct).get();
        if(product != null){
            String url = cloundService.uploadImage(image);
            product.setImageMain(url);
            productRespository.save(product);
            return "Success";
        }else{
            return "Không tìm thấy product";
        }
    }

    @Override
    public String insertImageProduct(int idProduct, MultipartFile image) throws IOException {
        Product product = productRespository.findById(idProduct).get();
        if(product != null){
            String url = cloundService.uploadImage(image);
            ImageProduct newObj = new ImageProduct();
            newObj.setIdImage(0);
            newObj.setImage(url);
            newObj.setProduct(product);
            imageProductRespository.save(newObj);
            return "Success";
        }else{
            return "Không tìm thấy product";
        }
    }

    @Override
    public String insertChooseSize(int idProduct, MultipartFile image) throws IOException {
        Product product = productRespository.findById(idProduct).get();
        if(product != null){
            String url = cloundService.uploadImage(image);
            product.setChoosingSize(url);
            productRespository.save(product);
            return "Success";
        }else{
            return "Không tìm thấy product";
        }
    }

    @Override
    public String insertProduct(ProductRequest productRequest) {
        Optional<Sale> optionalSale = saleRespository.findById(productRequest.getIdSale());
        Optional<Category> optionalCategory = categoryRepository.findById(productRequest.getIdCategoty());
        Product newObj = new Product();
        if (optionalCategory.isPresent()) {
            if(optionalSale.isPresent() ){
                Sale sale = optionalSale.get();
                newObj.setSale(sale);
            }
            Category category = optionalCategory.get();
            newObj.setCategory(category);
            newObj.setProductName(productRequest.getProductName());
            newObj.setProductDes(productRequest.getProductDes());
            newObj.setImportPrice(productRequest.getImportPrice());
            newObj.setExportPrice(productRequest.getExportPrice());
            productRespository.save(newObj);

            return "Thêm thành công";
        } else {
            return "Không tìm thấy Sale hoặc Category tương ứng";
        }
    }


    @Override
    public List<ProductDetails> getDetailProductByID(int idProduct) {
        return productDetailsRespository.getByIDProduct(idProduct);
    }

    @Override
    public List<ImageProduct> getListImageProduct(int idProduct) {
        return imageProductRespository.getListImageByIDProduct(idProduct);
    }

    @Override
    public String insertSizeAndColorProduct(int idProduct, int idSize, int idColor, int productRemain) {
        ProductDetails productDetails = productDetailsRespository.checkInsert(idProduct, idSize, idColor);
        if(productDetails != null){
            productDetails.setProductRemain(productDetails.getProductRemain() + productRemain);
            productDetailsRespository.save(productDetails);
            return "Success";
        }else{
            productDetailsRespository.insertSizeAndColorProduct(idProduct, idSize, idColor, productRemain);
            return "Success";
        }

    }

    @Override
    public String updateProduct(ProductRequest productRequest, int idProduct) {
        Optional<Product> product = productRespository.findById(idProduct);
        Optional<Sale> optionalSale = saleRespository.findById(productRequest.getIdSale());
        Optional<Category> optionalCategory = categoryRepository.findById(productRequest.getIdCategoty());
        if(product.isPresent()){
            Product updateProduct = product.get();
            if (optionalCategory.isPresent()) {
                if(optionalSale.isPresent() ){
                    Sale sale = optionalSale.get();
                    updateProduct.setSale(sale);
                }
                Category category = optionalCategory.get();
                updateProduct.setCategory(category);
                updateProduct.setProductName(productRequest.getProductName());
                updateProduct.setProductDes(productRequest.getProductDes());
                updateProduct.setImportPrice(productRequest.getImportPrice());
                updateProduct.setExportPrice(productRequest.getExportPrice());
                productRespository.save(updateProduct);

                return "Cập nhật thành công";
            } else {
                return "Không tìm thấy Sale hoặc Category tương ứng";
            }

        }else{
            return "Không tìm thấy product";
        }
    }
}
