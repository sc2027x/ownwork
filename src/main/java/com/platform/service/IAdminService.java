package com.platform.service;

import com.platform.domain.Admin;


public interface IAdminService {
     Admin Login(String zh,String pwd);

     Boolean addAdmin(Admin admin);

     Boolean updateAdmin(Admin admin);

     Admin getAdminInfo(Admin admin);
}
