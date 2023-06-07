package com.spring_e_commerce.web.service;


import com.spring_e_commerce.web.dto.AdminDto;
import com.spring_e_commerce.web.model.Admin;

public interface AdminService {

    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);


}
