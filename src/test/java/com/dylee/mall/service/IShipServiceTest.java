package com.dylee.mall.service;

import com.dylee.mall.Form.ShippingForm;
import com.dylee.mall.MallApplicationTests;
import com.dylee.mall.enums.ResponseEnum;
import com.dylee.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
@Slf4j
public class IShipServiceTest extends MallApplicationTests {

    @Autowired
    private IShipService shipService;

    private Integer uid = 1;
    @Test
    public void add() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverAddress("海原县文昌小区");
        shippingForm.setReceiverCity("ZhongWei");
        shippingForm.setReceiverDistrict("Haichenzhen");
        shippingForm.setReceiverMobile("110120");
        shippingForm.setReceiverName("dylee");
        shippingForm.setReceiverProvince("NX");
        shippingForm.setReceiverZip("100000");
        ResponseVo<Map<String, Integer>> responseVo = shipService.add(uid, shippingForm);
        log.info("responseVo={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
    @Test
    public void delete() {
        ResponseVo responseVo = shipService.delete(1, 5);
        log.info("responseVo={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
    @Test
    public void update() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverAddress("海原县文昌小区2");
        shippingForm.setReceiverCity("ZhongWei2");
        shippingForm.setReceiverDistrict("Haichenzhen1");
        shippingForm.setReceiverMobile("1101201");
        shippingForm.setReceiverName("dylee1");
        shippingForm.setReceiverProvince("NX1");
        shippingForm.setReceiverZip("100001");
        Integer shippingId = 8;
        ResponseVo responseVo = shipService.update(uid, shippingId, shippingForm);
        log.info("responseVo={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = shipService.list(uid, 2, 5);
        log.info("responseVo={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

}