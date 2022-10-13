package com.example.twrental.repository;

import com.example.twrental.model.Admin;
import com.example.twrental.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findAdminByUsername(String username);

}
