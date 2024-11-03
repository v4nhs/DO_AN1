package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    @Query(value = "select * from profile where email = ?1", nativeQuery = true)
    Profile findByGmail(String email);
}
