package com.imooc.service.impl;

import com.imooc.mapper.CarouselMapper;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Users;
import com.imooc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> querryAll(Integer isShow) {
        Example carouselExample=new Example(Carousel.class);
        carouselExample.orderBy("sort").desc();
        Example.Criteria carouselCriteria=carouselExample.createCriteria();
        carouselCriteria.andEqualTo("isShow",isShow);
        List<Carousel> result=carouselMapper.selectByExample(carouselExample);
        return result;
    }
}
