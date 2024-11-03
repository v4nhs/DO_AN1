package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.DTO.BillDTO;
import com.example.WebBanQuanAo.DTO.BillDetailsDTO;
import com.example.WebBanQuanAo.DTO.OrderDTO;
import com.example.WebBanQuanAo.DTO.OrderDetailsDTO;
import com.example.WebBanQuanAo.Entity.*;
import com.example.WebBanQuanAo.Repository.*;
import com.example.WebBanQuanAo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRespository orderRespository;
    @Autowired
    private OrderDetailsRespository orderDetailsRespository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private VoucherRespository voucherRespository;
    @Autowired
    private ProductRespository productRespository;
    @Autowired
    private SizeRespository sizeRespository;
    @Autowired
    private ColorRespository colorRespository;
    @Autowired
    private CartRepository cartRepository;
    @Override
    public ResponseEntity<?> insertOrder(BillDTO billDTO) {
        Order order = new Order();
        if (billDTO.getIdVoucher() != 0) {
            Optional<Voucher> voucherOptional = voucherRespository.findById(billDTO.getIdVoucher());
            if (voucherOptional.isPresent()) {
                order.setVoucher(voucherOptional.get());
            }
        }

        order.setTotalPrice(billDTO.getTotalPrice());
        order.setTotalItem(billDTO.getTotalItem());
        order.setTotalDiscount(billDTO.getTotalDiscount());
        order.setTotalFinal(billDTO.getTotalFinal());
        order.setProfile(profileRepository.findById(billDTO.getIdProfile()).get());
        order.setStatusOrder("Chờ xác nhận");
        order.setOrderType("Thanh toán khi nhận hàng");
        order.setStatusPayment("Chưa thanh toán");
        order.setTenNguoiNhan(billDTO.getTenNguoiNhan());
        order.setGhiChu(billDTO.getGhiChu());
        order.setEmail(billDTO.getEmail());
        order.setPhone(billDTO.getPhone());
        order.setDiaChiNhanHang(billDTO.getDiaChiNhanHang());
        order.setThanhPho(billDTO.getThanhPho());
        orderRespository.save(order);

        for (BillDetailsDTO a : billDTO.getBillDetailsDTOList()) {
            Product product = productRespository.findById(a.getIdProduct()).get();
            Size size = sizeRespository.findById(a.getIdSize()).get();
            Color color = colorRespository.findById(a.getIdColor()).get();

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(order);
            orderDetails.setProduct(product);
            orderDetails.setSize(size);
            orderDetails.setColor(color);
            orderDetails.setQuantity(a.getQuantity());
            orderDetails.setTotalPrice(a.getTotalPrice2());
            orderDetailsRespository.save(orderDetails);
        }

        // Thêm kiểm tra null trước khi duyệt qua listIDCart
        if (billDTO.getListIDCart() != null) {
            for (int a : billDTO.getListIDCart()) {
                Optional<Cart> deleteCart = cartRepository.findById(a);
                deleteCart.ifPresent(cartRepository::delete);
            }
        }

        return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
    }

    @Override
    public List<OrderDTO> getOrdersByProfileId(int idProfile) {
        List<Object[]> results = orderRespository.getOrderByIdProfile(idProfile);
        Map<Integer, OrderDTO> orderMap = new HashMap<>();

        for (Object[] result : results) {
            int orderId = (int) result[1];
            OrderDTO orderDTO = orderMap.get(orderId);

            if (orderDTO == null) {
                orderDTO = new OrderDTO();
                orderDTO.setOrderAt((Date) result[0]);
                orderDTO.setIdOrder((int) result[1]);
                orderDTO.setTotalPrice((float) result[2]);
                orderDTO.setTotalItem((int) result[3]);
                orderDTO.setTotalDiscount((float) result[4]);
                orderDTO.setTotalFinal((float) result[5]);
                orderDTO.setOrderType((String) result[6]);
                orderDTO.setStatusOrder((String) result[7]);
                orderDTO.setStatusPayment((String) result[8]);
                orderDTO.setOrderDetails(new ArrayList<>());

                orderMap.put(orderId, orderDTO);
            }

            OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
            orderDetailsDTO.setQuantity((int) result[9]);
            orderDetailsDTO.setTotalPrice((float) result[10]);
            orderDetailsDTO.setProductName((String) result[11]);
            orderDetailsDTO.setSizeName((String) result[12]);
            orderDetailsDTO.setColorName((String) result[13]);
            orderDetailsDTO.setProductPrice((float) result[14]);

            orderDTO.getOrderDetails().add(orderDetailsDTO);
        }

        return new ArrayList<>(orderMap.values());
    }

    @Override
    public String confirmRepair(int idOrder) {
         orderRespository.updateStatusOrder("Đã nhận hàng", idOrder);
         return "Success";
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRespository.findAll();
    }

    @Override
    public String updateStatusOrder(String status, int idOrder) {
         orderRespository.updateStatusOrder(status, idOrder);
         return "Success";
    }
}
