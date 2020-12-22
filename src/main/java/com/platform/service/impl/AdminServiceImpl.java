package com.platform.service.impl;

import com.platform.domain.Admin;
import com.platform.mapper.AdminMapper;
import com.platform.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements IAdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin Login(String zh,String pwd) {
        return adminMapper.Login(zh,pwd);
    }

    @Override
    public Boolean addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public Boolean updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public Admin getAdminInfo(Admin admin) {
        return adminMapper.getAdminInfo(admin);
    }
}
