package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemInfoVO;
import com.imooc.service.ItemService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="商品接口",tags={"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情",notes = "查询商品详情",httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(@ApiParam(name="itemId",value = "商品Id",required = true)
                                      @PathVariable String itemId){
        if (StringUtils.isBlank(itemId)){
            return IMOOCJSONResult.errorMsg(null);
        }
        Items item=itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgList=itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecList=itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam=itemService.queryItemParam(itemId);
        ItemInfoVO itemInfoVO=new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemImgList(itemsImgList);
        itemInfoVO.setItemSpecList(itemsSpecList);
        itemInfoVO.setItemParams(itemsParam);

        return IMOOCJSONResult.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价等级",notes = "查询商品评价等级",httpMethod = "GET")
    @GetMapping("/commentLevel")
    public IMOOCJSONResult commentLevel(@ApiParam(name="itemId",value = "商品Id",required = true)
                                  @RequestParam String itemId){
        if (StringUtils.isBlank(itemId)){
            return IMOOCJSONResult.errorMsg(null);
        }
        CommentLevelCountsVO countsVO =itemService.queryCommentCounts(itemId);

        return IMOOCJSONResult.ok(countsVO);
    }
}
