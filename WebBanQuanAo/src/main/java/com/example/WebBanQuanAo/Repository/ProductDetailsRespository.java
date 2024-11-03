package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductDetailsRespository extends JpaRepository<ProductDetails, Integer> {
    @Query(value = "select * from product_details where id_product = ?1", nativeQuery = true)
    List<ProductDetails> getByIDProduct(int idProduct);

    @Transactional
    @Modifying
    @Query(value = "insert into product_details(id_product, id_size, id_color, product_remain) values (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertSizeAndColorProduct(int idProduct, int idSize, int idColor, int productRemain);
    @Modifying
    @Query(value = "UPDATE product_details SET id_product = ?1, id_size = ?2, id_color = ?3, product_remain = ?4 where id_product_details = ?5", nativeQuery = true)
    void updateSizeAndColorProduct(int idProduct, int idSize, int idColor, int productRemain, int idProductDetails);

    @Query(value = "select * from product_details where id_product = ?1 and id_size = ?2 and id_color = ?3", nativeQuery = true)
    ProductDetails checkInsert(int idProduct, int idSize, int idColor);
}
