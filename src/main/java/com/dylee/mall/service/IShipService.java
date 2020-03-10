package com.dylee.mall.service;

import com.dylee.mall.Form.ShippingForm;
import com.dylee.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IShipService {
    ResponseVo<Map<String,Integer>> add(Integer uid, ShippingForm shippingForm);
    ResponseVo delete(Integer uid,Integer shippingId);
    ResponseVo update(Integer uid,Integer shippingId,ShippingForm shippingForm);
    ResponseVo<PageInfo> list(Integer uid,Integer pageNum,Integer pageSize);
}
