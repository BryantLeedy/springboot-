package com.dylee.mall.service;

import com.dylee.mall.vo.ProductDetailVo;
import com.dylee.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

public interface IProductService {
    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
