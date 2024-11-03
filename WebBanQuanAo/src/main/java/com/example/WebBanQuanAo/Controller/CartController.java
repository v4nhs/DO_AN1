package com.example.WebBanQuanAo.Controller;

import com.example.WebBanQuanAo.DTO.CartRequest;
import com.example.WebBanQuanAo.Entity.Cart;
import com.example.WebBanQuanAo.Service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/getAllCart")
    public List<Cart> getAllCart(){
        return cartService.getAllCart();
    }
    @PostMapping("/insertCart")
    public String insertCart(@RequestBody CartRequest cartRequest){
        return cartService.insertCart(cartRequest);
    }
    @PutMapping("/updateQuantity")
    public String update(@RequestParam("idCart") int idCart,
                         @RequestParam("quantity") int quantity){
        return cartService.updateCart(idCart, quantity);
    }
    @DeleteMapping("/delete/{IDCart}")
    public String deleteCart(@PathVariable int IDCart){
        return cartService.deleteCart(IDCart);
    }

    @GetMapping("/getCartByIDProfile/{IDProfile}")
    public List<Cart> getByIDProfile(@PathVariable int IDProfile){
        return cartService.getByIdProfile(IDProfile);
    }
}
