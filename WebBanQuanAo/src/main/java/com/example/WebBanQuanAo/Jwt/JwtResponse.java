package com.example.WebBanQuanAo.Jwt;

import com.example.WebBanQuanAo.Entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private String role;
    private Boolean status;
    private Profile profile;
}