package com.asianrapid.talin.services.order.controller;

import com.asianrapid.talin.api.client.order.OrderServiceApi;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dbo.Order;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.services.order.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName OrderController
 * @Author Nio
 * @Date 2019/8/24 0024
 * @Version V1.0
 **/
@Api(tags = "订单服务接口")
@RequestMapping("/order")
@RestController
public class OrderController extends BaseController implements OrderServiceApi {

    @Autowired
    private OrderService orderService;

    @PostMapping("/insert")
    @Override
    public BaseResponse insertOrder() {
        try {
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setGoodsId(6);
            orderService.insertOrder(order);
        } catch (Exception e) {
            throw new TalinServiceException();
        }
        return BaseResponse.ok();
    }
}
