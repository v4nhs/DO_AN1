package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRespository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT o.order_at AS orderAt, " +
            "       o.id_order AS idOrder, " +
            "       o.total_price AS orderTotalPrice, " +
            "       o.total_item AS orderTotalItem, " +
            "       o.total_discount AS orderTotalDiscount, " +
            "       o.total_final AS orderTotalFinal, " +
            "       o.order_type AS orderType, " +
            "       o.status_order AS statusOrder, " +
            "       o.status_payment AS statusPayment, " +
            "       od.quantity AS detailQuantity, " +
            "       od.total_price AS detailTotalPrice, " +
            "       p.product_name AS productName, " +
            "       s.size_name AS sizeName, " +
            "       c.color_name AS colorName," +
            "       p.export_price AS productPrice " +
            "FROM orders o " +
            "JOIN order_details od ON o.id_order = od.id_order " +
            "JOIN product p ON od.id_product = p.id_product " +
            "JOIN size s ON od.id_size = s.id_size " +
            "JOIN color c ON od.id_color = c.id_color " +
            "WHERE o.id_profile = ?1", nativeQuery = true)
    List<Object[]> getOrderByIdProfile(int idProfile);
    @Transactional
    @Modifying
    @Query(value = "update orders set status_order = ?1 where id_order = ?2", nativeQuery = true)
    void updateStatusOrder(String status, int idOrder);
}
