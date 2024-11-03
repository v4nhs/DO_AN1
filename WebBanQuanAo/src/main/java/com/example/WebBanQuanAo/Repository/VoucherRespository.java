package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRespository extends JpaRepository<Voucher, Integer> {
    @Query(value = "SELECT COUNT(*) FROM voucher WHERE code = ?1 AND ?2 >= total_price_apply AND quantity > 0 AND CURRENT_DATE() BETWEEN start_date AND end_date", nativeQuery = true)
    int checkVoucher(String code, float totalPrice);
    @Query(value = "select * from voucher where code = ?1", nativeQuery = true)
    Voucher getByCode(String code);
}
