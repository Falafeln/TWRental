package com.example.twrental.controller;

import com.example.twrental.model.Admin;
import com.example.twrental.model.Adress;
import com.example.twrental.repository.AdminRepository;
import com.example.twrental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private AdminService adminS;

    @Autowired
    private AdminRepository adminR;

    @PostMapping("/saveAdmin")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminS.saveAdmin(admin), HttpStatus.CREATED);
    }

    @GetMapping("/getAdmin")
    public List<Admin> getAllAdmin(){return adminS.getAllAdmins();}

    @GetMapping("/adminID{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") int id){
        return new ResponseEntity<Admin>(adminS.getAdminById(id),HttpStatus.OK);
    }

    @PutMapping("/updateAdmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id, @RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminS.updateAdmin(admin,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteAdmin(@PathVariable ("id") int id){
        adminS.deleteAdmin(id);
        return new ResponseEntity<String>("Admin deleted!", HttpStatus.OK);
    }

    @GetMapping("/sortAdminAsc")
    public List<Admin>sortAdminAsc(String username){
        return adminR.findAdminByUsername(username);
    }


}
