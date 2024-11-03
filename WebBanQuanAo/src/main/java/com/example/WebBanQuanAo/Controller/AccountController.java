package com.example.WebBanQuanAo.Controller;

import com.example.WebBanQuanAo.Jwt.AccountDetails;
import com.example.WebBanQuanAo.Jwt.JwtResponse;
import com.example.WebBanQuanAo.Jwt.JwtUtils;
import com.example.WebBanQuanAo.Repository.AccountRepository;
import com.example.WebBanQuanAo.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AccountController {
    private final JwtUtils jwtUtils;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String userName,
                                   @RequestParam("password") String passWord){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, passWord));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        AccountDetails userDetails = (AccountDetails) authentication.getPrincipal();
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setAccessToken(jwt);
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setStatus(userDetails.getStatus());
        jwtResponse.setRole(userDetails.getAuthority().getAuthority());
        jwtResponse.setProfile(userDetails.getProfile());
        return ResponseEntity.ok(jwtResponse);
    }


}
