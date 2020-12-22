package com.platform.mapper;


import com.platform.domain.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface AdminMapper {
    @Select("select * from cultural_admin where username=#{zh} and password=#{pwd}")
    Admin Login(@Param("zh") String zh, @Param("pwd") String pwd);

    @Insert("insert into cultural_admin values(null,#{username},#{password})")
    Boolean addAdmin(Admin admin);

    @Update("update cultural_admin set username=#{username},password=#{password} where pid=#{pid}")
    Boolean updateAdmin(Admin admin);

    @Select("select * from cultural_admin where pid=#{pid}")
    Admin getAdminInfo(Admin admin);
}
