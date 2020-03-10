package com.dylee.mall.service;

import com.dylee.mall.MallApplicationTests;
import com.dylee.mall.enums.ResponseEnum;
import com.dylee.mall.vo.ProductDetailVo;
import com.dylee.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IProductServiceImplTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;
    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 1, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void detail(){
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}