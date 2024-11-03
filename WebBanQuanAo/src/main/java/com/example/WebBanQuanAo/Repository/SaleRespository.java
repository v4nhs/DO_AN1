package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRespository extends JpaRepository<Sale, Integer> {
}
