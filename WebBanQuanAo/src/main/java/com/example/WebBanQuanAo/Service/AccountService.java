package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.Account;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {
    String register(String username, String password, String email);

    String changePass(String email, String password);
}
