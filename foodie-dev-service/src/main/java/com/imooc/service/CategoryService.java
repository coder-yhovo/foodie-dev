package com.imooc.service;

import com.imooc.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有一级分类
     * @param isShow
     * @return
     */
    public List<Category> queryAllRootLevelCat(Integer isShow);
}
