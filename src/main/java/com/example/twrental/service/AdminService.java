package com.example.twrental.service;

import com.example.twrental.exception.ResourceNotFoundException;
import com.example.twrental.model.Admin;
import com.example.twrental.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminServiceInterface{

    @Autowired
    private AdminRepository adminR;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminR.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminR.findAll();
    }

    @Override
    public Admin getAdminById(int id) {
        Optional<Admin> a = adminR.findById(id);
        if (a.isPresent()){
            return a.get();
        }else {
            throw new ResourceNotFoundException("Admin", "Id", a);
        }

    }

    @Override
    public Admin updateAdmin(Admin admin, int id) {
        Admin a = adminR.findById(id).orElseThrow(()-> new ResourceNotFoundException("Admin", "Id", id));
        a.setEmail(a.getEmail());
        a.setFirstname(a.getFirstname());
        a.setLastname(a.getLastname());
        a.setUsername(a.getUsername());
        a.setPwd(a.getPwd());
        a.setPhone(a.getPhone());
        adminR.save(a);
        return a;
    }

    @Override
    public void deleteAdmin(int id) {
        adminR.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "Id", id));
        adminR.deleteById(id);
    }
}
