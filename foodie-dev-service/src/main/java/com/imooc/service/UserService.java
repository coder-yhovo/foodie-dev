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
     * @param userBo
     * @return
     */
    public Users CreateUsers(UserBo userBo);
}
