package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Account;
import com.example.WebBanQuanAo.Jwt.AccountDetails;
import com.example.WebBanQuanAo.Repository.AccountRepository;
import com.example.WebBanQuanAo.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Account accountEntity = accountRepository.findByUserName(username);

        if (accountEntity == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(accountEntity.getPassWord());
        accountEntity.setPassWord(encodedPassword);

        return AccountDetails.build(accountEntity);
    }
}

