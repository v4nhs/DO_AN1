package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUserName(String username);
    @Query(value = "select * from accounts where id_profile = ?1", nativeQuery = true)
    Account findByIDProfile(int idProfile);
}
