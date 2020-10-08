package com.shuyuan.judd.channel.ldlj.controller;

import com.alibaba.fastjson.JSONObject;
import com.shuyuan.judd.client.model.request.channel.order.RefundOrderQueryRequest;
import com.shuyuan.judd.client.model.request.channel.order.RefundOrderQueryResponse;
import com.shuyuan.judd.client.model.request.channel.order.RefundOrderRequest;
import com.shuyuan.judd.client.model.request.channel.order.RefundOrderResponse;
import com.shuyuan.judd.client.model.request.channel.payment.EbankPaymentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.shuyuan.judd.base.model.Response;
import spring.shuyuan.judd.base.utils.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Slf4j
@Api(tags = "订单创建、完成确认")
@RestController
@RequestMapping("/refund")
public class RefundOrderController {

    @ApiOperation("创建订单")
    @PostMapping("/placeOrder")
    public Response<RefundOrderResponse> placeOrder(@RequestBody RefundOrderRequest req) throws InvocationTargetException, IllegalAccessException {
        log.info("req: {}", JSONObject.toJSONString(req));
        RefundOrderResponse r = new RefundOrderResponse();
        r.setDate(req.getDate());
        r.setOrderNo(req.getOrderNo());
        r.setOriDate(req.getOriDate());
        r.setOriOrderNo(req.getOriOrderNo());
        r.setTradeNo(req.getOrderNo());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(), "yyyyMMdd"));
        Response<RefundOrderResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "退款订单查询")
    @PostMapping("/queryOrder")
    public Response<RefundOrderQueryResponse> queryOrder(@RequestBody RefundOrderQueryRequest req) throws InvocationTargetException, IllegalAccessException {
        log.info("req: {}",JSONObject.toJSONString(req));
        RefundOrderQueryResponse r = new RefundOrderQueryResponse();
        r.setDate(req.getDate());
        r.setOrderNo(req.getOrderNo());
        r.setTradeNo(req.getOrderNo());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(), "yyyyMMdd"));
        r.setTradeState("1");
        Response<RefundOrderQueryResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

}
