package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.DTO.CartRequest;
import com.example.WebBanQuanAo.Entity.Cart;

import java.util.List;

public interface CartService {
    String insertCart(CartRequest cartRequest);
    List<Cart> getAllCart();
    String updateCart(int idCart, int quantity);
    String deleteCart(int idCart);

    List<Cart> getByIdProfile(int idProfile);
}
