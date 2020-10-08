package com.shuyuan.judd.channel.ldlj.controller;

import com.shuyuan.judd.client.model.request.channel.order.FinishOrderRequest;
import com.shuyuan.judd.client.model.request.channel.order.FinishOrderResponse;
import com.shuyuan.judd.client.model.request.channel.order.FundInOrderRequest;
import com.shuyuan.judd.client.model.request.channel.order.FundInOrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.shuyuan.judd.base.model.Response;

import java.lang.reflect.InvocationTargetException;

@Api(tags = "订单创建、完成确认")
@RestController
@RequestMapping("/fundin")
public class FundInOrderController {
    private static final Logger logger = LoggerFactory.getLogger(FundInOrderController.class);

    @ApiOperation("创建订单")
    @PostMapping("/placeOrder")
    public Response<FundInOrderResponse> placeOrder(@RequestBody FundInOrderRequest req) throws InvocationTargetException, IllegalAccessException {
        logger.info("placeOrder, req:{}", req);
        FundInOrderResponse r = new FundInOrderResponse();
        r.setDate(req.getDate());
        r.setTradeNo(req.getOrderNo());
        Response<FundInOrderResponse> res =  Response.createSuccess(r);
        logger.info("placeOrder, res:{}",res);
        return res;
    }

    @ApiOperation("确认完成担保订单")
    @PostMapping("/finishQuaranteeOrder")
    public Response<FinishOrderResponse> finishQuaranteeOrder(@RequestBody FinishOrderRequest req){
        logger.info("finishQuaranteeOrder, req:{}", req);
        FinishOrderResponse r = new FinishOrderResponse();
        r.setTradeNo(req.getTradeNo());
        Response<FinishOrderResponse> res = Response.createSuccess(r);
        logger.info("finishQuaranteeOrder, res:{}",res);
        return res;
    }
}
