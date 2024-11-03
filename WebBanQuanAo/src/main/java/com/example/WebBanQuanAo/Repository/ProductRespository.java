package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where id_categories = ?1", nativeQuery = true)
    List<Product> getByIDCate(int idCate);
}
