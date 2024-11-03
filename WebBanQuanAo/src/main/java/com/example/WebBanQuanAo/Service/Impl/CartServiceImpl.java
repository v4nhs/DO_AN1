package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.DTO.CartRequest;
import com.example.WebBanQuanAo.Entity.*;
import com.example.WebBanQuanAo.Repository.*;
import com.example.WebBanQuanAo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProductRespository productRespository;
    @Autowired
    private SizeRespository sizeRespository;
    @Autowired
    private ColorRespository colorRespository;
    @Override
    public String insertCart(CartRequest cartRequest) {
        Cart getCart = cartRepository.getCart(cartRequest.getIdProfile(), cartRequest.getIdProduct(),
                                              cartRequest.getIdSize(), cartRequest.getIdColor());
        if(getCart != null){
            getCart.setQuantity(getCart.getQuantity() + cartRequest.getQuantity());
            cartRepository.save(getCart);
            return "Success";
        }else{
            Profile profile = profileRepository.findById(cartRequest.getIdProfile()).get();
            Product product = productRespository.findById(cartRequest.getIdProduct()).get();
            Size size = sizeRespository.findById(cartRequest.getIdSize()).get();
            Color color = colorRespository.findById(cartRequest.getIdColor()).get();

            Cart cart = new Cart();
            cart.setProfile(profile);
            cart.setProduct(product);
            cart.setSize(size);
            cart.setColor(color);
            cart.setQuantity(cartRequest.getQuantity());
            cartRepository.save(cart);
            return "Success";
        }
    }

    @Override
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public String updateCart(int idCart, int quantity) {
        Cart cart = cartRepository.findById(idCart).get();
        if(cart != null){
            cart.setQuantity(quantity);
            cartRepository.save(cart);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }

    @Override
    public String deleteCart(int idCart) {
        Cart cart = cartRepository.findById(idCart).get();
        if(cart != null){
            cartRepository.delete(cart);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }

    @Override
    public List<Cart> getByIdProfile(int idProfile) {
        return cartRepository.getCartByIDAndProfile(idProfile);
    }
}
