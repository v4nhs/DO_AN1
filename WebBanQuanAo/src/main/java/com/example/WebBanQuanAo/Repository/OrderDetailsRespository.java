package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRespository extends JpaRepository<OrderDetails, Integer> {
}
