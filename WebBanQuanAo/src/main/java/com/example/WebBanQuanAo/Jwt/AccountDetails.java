package com.example.WebBanQuanAo.Jwt;

import com.example.WebBanQuanAo.Entity.Account;
import com.example.WebBanQuanAo.Entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails implements UserDetails {
    private int accountId;
    private String username;
    private String password;
    private GrantedAuthority authority;
    private String phone;
    private Boolean status;
    private Profile profile;

    public static AccountDetails build(Account accountEntity) {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setUsername(accountEntity.getUserName());
        accountDetails.setPassword(accountEntity.getPassWord());
        accountDetails.setStatus(accountEntity.getStatus());
        accountDetails.setAuthority(new SimpleGrantedAuthority(accountEntity.getRole().getName()));
        accountDetails.setProfile(accountEntity.getProfile());
        return accountDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(this.authority); // Hoặc trả về danh sách GrantedAuthority nếu có nhiều roles
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
