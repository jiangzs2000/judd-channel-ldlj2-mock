package com.shuyuan.judd.channel.ldlj.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.shuyuan.judd.client.model.request.channel.order.MemberWithdrawOrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.shuyuan.judd.base.model.Response;
import spring.shuyuan.judd.base.utils.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Api(tags = "平台账户操作")
@RestController
@RequestMapping("/plataccount")
public class PlatAccountController {
    @ApiOperation(value = "查询账户余额")
    @PostMapping("/queryBalance")
    public Response<Map<String, String>> queryBalance(){
        log.info("queryBalance");
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
    public Response<MemberWithdrawOrderResponse> withdraw(@RequestParam(name="orderNo") String orderNo, @RequestParam(name="date") String date, @RequestParam(name="amount") long amount) throws InvocationTargetException, IllegalAccessException {
        log.info("orderNo:{}", orderNo);
        MemberWithdrawOrderResponse r = new MemberWithdrawOrderResponse();
        r.setAmount(amount);
        r.setChannelRetFeeAmt(5L);
        r.setDate(date);
        r.setOrderNo(orderNo);
        r.setTradeNo(orderNo);
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(), "yyyyMMdd"));
        Response<MemberWithdrawOrderResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }
}
