package com.example.twrental.service;

import com.example.twrental.model.Admin;


import java.util.List;

public interface AdminServiceInterface {

    Admin saveAdmin(Admin admin);
    List<Admin> getAllAdmins();
    Admin getAdminById(int id);
    Admin updateAdmin(Admin admin, int id);
    void deleteAdmin(int id);

}
