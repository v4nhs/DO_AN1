package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageProductRespository extends JpaRepository<ImageProduct, Integer> {
    @Query(value = "select * from imageproduct where id_product = ?1", nativeQuery = true)
    List<ImageProduct> getListImageByIDProduct(int idProduct);
}
