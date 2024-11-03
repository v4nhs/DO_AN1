package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "select * from cart where id_profile = ?1 and id_product = ?2 and id_size = ?3 and id_color = ?4", nativeQuery = true)
    Cart getCart(int idProfile, int idProduct, int idSize, int idColor);
    @Query(value = "select * from cart where id_profile = ?1", nativeQuery = true)
    List<Cart> getCartByIDAndProfile(int idProfile);

}
