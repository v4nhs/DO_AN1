package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.DTO.ProductDetailsRequest;
import com.example.WebBanQuanAo.DTO.ProductRequest;
import com.example.WebBanQuanAo.Entity.ImageProduct;
import com.example.WebBanQuanAo.Entity.Product;
import com.example.WebBanQuanAo.Entity.ProductDetails;
import com.example.WebBanQuanAo.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/getProductByID/{IDProduct}")
    public ResponseEntity<?> getProductByID(@PathVariable int IDProduct){
        return productService.getByID(IDProduct);
    }
    @GetMapping("/getByCateID/{IDCate}")
    public ResponseEntity<?> getByCateID(@PathVariable int IDCate){
        return productService.getByIDCate(IDCate);
    }

    @PostMapping("/uploadImageMainProduct")
    public String upload(@RequestParam("idProduct") int idProduct,
                         @RequestParam("image") MultipartFile img) throws IOException {
        return productService.uploadImageProduct(idProduct, img);
    }

    @PostMapping("/updateListImageProduct")
    public String insertImage(@RequestParam("idProduct") int idProduct,
                              @RequestParam("image") MultipartFile img) throws IOException {
        return productService.insertImageProduct(idProduct, img);
    }

    @PostMapping("/insertChooseSize")
    public String insertChooseSize(@RequestParam("idProduct") int idProduct,
                         @RequestParam("image") MultipartFile img) throws IOException {
        return productService.insertChooseSize(idProduct, img);
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@RequestBody ProductRequest productRequest){
        return productService.insertProduct(productRequest);
    }

    @PutMapping("/updateProduct/{IDProduct}")
    public String insertProduct(@RequestBody ProductRequest productRequest, @PathVariable int IDProduct){
        return productService.updateProduct(productRequest, IDProduct);
    }

    @GetMapping("/getDetailsProduct/{IDProduct}")
    public List<ProductDetails> getDetails(@PathVariable int IDProduct){
        return productService.getDetailProductByID(IDProduct);
    }

    @GetMapping("/getListImageProduct/{IDProduct}")
    public List<ImageProduct> getListImageProduct(@PathVariable int IDProduct){
        return productService.getListImageProduct(IDProduct);
    }


    @PostMapping("/insertProductDetails")
    public String insertSizeAndColorProduct(@RequestBody ProductDetailsRequest productDetailsRequest){
        return productService.insertSizeAndColorProduct(productDetailsRequest.getIdProduct(), productDetailsRequest.getIdSize(),
                productDetailsRequest.getIdColor(), productDetailsRequest.getProductRemain());
    }
}
