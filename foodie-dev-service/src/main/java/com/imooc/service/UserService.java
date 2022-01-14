package com.imooc.service;


import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;

public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return true存在 false不存在
     */
    public boolean queryUsernameIsExist(String username);

    /**
     *保存用户到数据库
     * @param userBo 前端发送的user json对象
     * @return 封装好的user
     */
    public Users CreateUsers(UserBo userBo);

    /**
     * 检索用户名和密码是否匹配
     * @param username 用户名
     * @param password 密码
     * @return 查询到的user
     */
    public Users queryUserForLogin(String username,String password);

}
