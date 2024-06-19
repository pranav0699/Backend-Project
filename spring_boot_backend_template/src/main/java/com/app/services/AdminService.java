package com.app.services;

import java.util.List;

import com.app.entities.Admin;

public interface AdminService {
	
	Admin loginAdmin(String username, String password);
	
	Admin registerAdmin(Admin admin);

    Admin loginAdmin(Admin admin);

   // Admin getAdminById(Long id);

    List<Admin> getAllAdmins();

}
