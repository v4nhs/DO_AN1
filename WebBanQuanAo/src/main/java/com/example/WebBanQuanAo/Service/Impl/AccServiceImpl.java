package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Account;
import com.example.WebBanQuanAo.Entity.Profile;
import com.example.WebBanQuanAo.Entity.Role;
import com.example.WebBanQuanAo.Repository.AccountRepository;
import com.example.WebBanQuanAo.Repository.ProfileRepository;
import com.example.WebBanQuanAo.Repository.RoleRepository;
import com.example.WebBanQuanAo.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public String register(String username, String password, String email) {
        Optional<Role> role = roleRepository.findById(1);
        Account getAcc = accountRepository.findByUserName(username);
        if(getAcc == null){
            Role getRole = null;
            if (role.isPresent()) {
                getRole = role.get();
            }
            if(getRole != null){
                Profile newProfile = new Profile();
                newProfile.setEmail(email);
                Account account = new Account();
                account.setPassWord(password);
                account.setUserName(username);
                account.setRole(getRole);
                account.setProfile(newProfile);
                account.setStatus(true);
                accountRepository.save(account);
                return "Success";
            }else{
                return "111";
            }
        }else{
            return "404";
        }


    }

    @Override
    public String changePass(String email, String password) {
        Profile profile = profileRepository.findByGmail(email);
        if(profile != null){
            Account account = accountRepository.findByIDProfile(profile.getIDProfile());
            account.setPassWord(password);
            accountRepository.save(account);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }
}
