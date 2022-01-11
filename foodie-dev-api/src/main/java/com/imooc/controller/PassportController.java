package com.imooc.controller;

import com.imooc.pojo.bo.UserBo;
import com.imooc.service.UserService;
import com.imooc.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username){
        //判断用户名是否为空
        if(StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //查找注册用户是否存在
        boolean isExist=userService.queryUsernameIsExist(username);
        if(isExist){
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        //请求成功
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBo userBo){
        String username=userBo.getUsername();
        String password=userBo.getPassword();
        String confirmPwd=userBo.getConfirmPassword();
        //判断用户名密码不为空
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)||StringUtils.isBlank(confirmPwd)){
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }
        //查询用户名是否存在
        boolean isExist=userService.queryUsernameIsExist(username);
        if(isExist){
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        //密码长度不能少于6
        if(password.length()<6){
            return IMOOCJSONResult.errorMsg("密码长度不能少于6");
        }
        //判断密码是否一致
        if(!password.equals(confirmPwd)){
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }
        //实现注册
        userService.CreateUsers(userBo);
        return IMOOCJSONResult.ok();
    }
}
