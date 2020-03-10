package com.dylee.mall.controller;

import com.dylee.mall.Form.ShippingForm;
import com.dylee.mall.consts.MallConst;
import com.dylee.mall.pojo.Shipping;
import com.dylee.mall.pojo.User;
import com.dylee.mall.service.IShipService;
import com.dylee.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ShippingController {
    @Autowired
    private IShipService shipService;
    @PostMapping("/shippings")
    public ResponseVo add(@Valid @RequestBody ShippingForm shippingForm,
                          HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return shipService.add(user.getId(),shippingForm);
    }
    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable Integer shippingId, HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return shipService.delete(user.getId(), shippingId);
    }
    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@PathVariable Integer shippingId,
                             @Valid @RequestBody ShippingForm shippingForm,
                             HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return shipService.update(user.getId(), shippingId,shippingForm);
    }
    @GetMapping("/shippings")
    public List<Shipping> list(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                               HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return (List<Shipping>) shipService.list(user.getId(),pageNum,pageSize);
    }
}
