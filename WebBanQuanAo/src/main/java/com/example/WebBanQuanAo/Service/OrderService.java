package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.DTO.BillDTO;
import com.example.WebBanQuanAo.DTO.OrderDTO;
import com.example.WebBanQuanAo.Entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<?> insertOrder(BillDTO billDTO);
    List<OrderDTO> getOrdersByProfileId(int idProfile);

    String confirmRepair(int idOrder);

    List<Order> getAllOrders();

    String updateStatusOrder(String status, int idOrder);
}
