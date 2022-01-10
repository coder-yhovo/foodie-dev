package com.imooc.service;


public interface UserService {
    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return true存在 false不存在
     */
    public boolean queryUsernameIsExist(String username);
}
