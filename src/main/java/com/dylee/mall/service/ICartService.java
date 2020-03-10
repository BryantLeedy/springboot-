package com.dylee.mall.service;

import com.dylee.mall.Form.CartAddForm;
import com.dylee.mall.Form.CartUpdateForm;
import com.dylee.mall.vo.CartVo;
import com.dylee.mall.vo.ResponseVo;

public interface ICartService {
    ResponseVo<CartVo> add(Integer uid,CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);
}
