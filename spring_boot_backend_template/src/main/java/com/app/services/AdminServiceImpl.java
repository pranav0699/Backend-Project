package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entities.Admin;
import com.app.repository.AdminRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Admin loginAdmin(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            return admin;
        }
        return null;
    }
    
    @Override
    public Admin registerAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
    
    @Override
    public Admin loginAdmin(Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();

        Admin existingAdmin = adminRepository.findByUsername(username);
        if (existingAdmin != null && passwordEncoder.matches(password, existingAdmin.getPassword())) {
            return existingAdmin;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
    
//    @Override
//    public Admin getAdminById(Long id) {
//        Optional<Admin> optionalAdmin = adminRepository.findById(id);
//        return optionalAdmin.orElse(null); // Handle null if admin is not found
//    }
    
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

}
