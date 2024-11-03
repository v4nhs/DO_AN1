package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.DTO.BillDTO;
import com.example.WebBanQuanAo.DTO.OrderDTO;
import com.example.WebBanQuanAo.Entity.Order;
import com.example.WebBanQuanAo.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/insertBill")
    public ResponseEntity<?> insertBill(@RequestBody BillDTO billDTO){
        return orderService.insertOrder(billDTO);
    }

    @GetMapping("/getOrderByProfile/{IDProfile}")
    public List<OrderDTO> getOrderByIDProfile(@PathVariable int IDProfile){
        return orderService.getOrdersByProfileId(IDProfile);
    }

    @PostMapping("/confirmRepair/{IDOrder}")
    public String confirmRepair(@PathVariable int IDOrder){
        return orderService.confirmRepair(IDOrder);
    }
    @GetMapping("/getAllOrder")
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }
    @PutMapping("/updateStatusOrder")
    public String updateStatusOrder(@RequestParam("status") String status,
                                    @RequestParam("idOrder") int idOrder){
        return orderService.updateStatusOrder(status, idOrder);
    }
}
