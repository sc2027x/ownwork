package com.platform.controller;

import com.platform.domain.Admin;
import com.platform.domain.JwtResult;
import com.platform.service.IAdminService;
import com.platform.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("login")
    public JwtResult<String> Login(HttpServletRequest request){
        JwtResult<String> result=new JwtResult<>();
        String zh= request.getParameter("username");
        String pwd=request.getParameter("password");
        if(!StringUtils.isEmpty(zh)&&!StringUtils.isEmpty(pwd)){
            Admin admin = adminService.Login(zh, pwd);
            if(admin!=null) {
                Map<String, Object> map = new HashMap<>();
                map.put("userName", "Oven");
                String token = JwtUtil.generateToken(map);
                result.setCode(200);
                result.setData(token);
            }
            else{
                result.setCode(301);
                result.setData("用户名或密码错误");
            }
        }else{
            result.setCode(302);
            result.setData("输入错误");
        }
        return result;
    }

    @GetMapping("logout")
    public String Logout(HttpServletRequest request){
        return "退出成功";
    }

    @GetMapping("addAdmin")
    public String addAdmin(Admin admin){
        if(adminService.addAdmin(admin))
            return "创建成功";
        return "创建失败";
    }

    @GetMapping("updateAdmin")
    public String updateAdmin(Admin admin){

        if(adminService.updateAdmin(admin))
            return "更新成功";
        return "更新失败";
    }

    @GetMapping("getAdminInfo")
    public Admin getAdminInfo(Admin admin){
        if(!StringUtils.isEmpty(adminService.getAdminInfo(admin)))
            return adminService.getAdminInfo(admin);
        return null;
    }


}
