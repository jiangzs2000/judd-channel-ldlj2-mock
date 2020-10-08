package com.shuyuan.judd.channel.ldlj.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.shuyuan.judd.channel.ldlj.feignservice.BizEngineOrderFeignService;
import com.shuyuan.judd.client.model.order.WithdrawOrder;
import com.shuyuan.judd.client.model.request.channel.order.MemberWithdrawOrderRequest;
import com.shuyuan.judd.client.model.request.channel.order.MemberWithdrawOrderResponse;
import com.shuyuan.judd.client.model.request.channel.order.WithdrawOrderQueryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.shuyuan.judd.base.model.Response;
import spring.shuyuan.judd.base.utils.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Api(tags = "成员商户账户操作")
@RestController
@RequestMapping("/memberaccount")
public class MemberAccountController {
    @Autowired
    private BizEngineOrderFeignService bizEngineOrderFeignService;
    @ApiOperation(value = "查询账户余额")
    @PostMapping("/queryBalance")
    public Response<Map<String, String>> queryBalance(@RequestParam(name="merchantNo") String merchantNo){
        log.info("merchantNo:{}", merchantNo);
        Map<String, String> r = new HashMap<>();
        List<Map<String, Object>> accounts = new ArrayList<>();
        for(int i =0; i < 5; i++){
            Map<String, Object> acc = new HashMap<>();
            BigDecimal balance = RandomUtil.randomBigDecimal();
            BigDecimal avlBal = RandomUtil.randomBigDecimal(balance);
            acc.put("balance", balance);
            acc.put("avl_bal", avlBal);
            acc.put("ass_bal", balance.subtract(avlBal));
            acc.put("acc_state", "1");
            accounts.add(acc);
        }
        r.put("balance_detail", JSONObject.toJSONString(accounts));
        Response<Map<String, String>> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "商户账户提现")
    @PostMapping("/withdraw")
    public Response<MemberWithdrawOrderResponse> withdraw(@RequestBody MemberWithdrawOrderRequest req) throws InvocationTargetException, IllegalAccessException {
        log.info("req:{}", req);
        MemberWithdrawOrderResponse r = new MemberWithdrawOrderResponse();
        r.setAmount(req.getAmount());
        r.setChannelRetFeeAmt(5L);
        r.setDate(req.getDate());
        r.setOrderNo(req.getOrderNo());
        r.setTradeNo(req.getOrderNo());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(), "yyyyMMdd"));
        Response<MemberWithdrawOrderResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "提现提现")
    @PostMapping("/withdrawQuery")
    public Response<WithdrawOrderQueryResponse> withdrawQuery(@RequestParam(name = "orderNo") String orderNo, @RequestParam(name="date") String date) throws InvocationTargetException, IllegalAccessException {
        log.info("orderno:{}, date:{}", orderNo, date);
        WithdrawOrderQueryResponse r = new WithdrawOrderQueryResponse();
        WithdrawOrder ord = bizEngineOrderFeignService.getWithdrawOrder(orderNo).getData();
        r.setAmount(ord.getAmount());
        r.setChannelRetFeeAmt(5L);
        r.setDate(ord.getDate());
        r.setOrderNo(ord.getOrderNo());
        r.setTradeNo(ord.getOrderNo());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(), "yyyyMMdd"));
        if(r.getAmount()%3 == 0){
            r.setTradeState("2");
        }else {
            r.setTradeState("1");
        }
        Response<WithdrawOrderQueryResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }
}
