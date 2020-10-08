package com.shuyuan.judd.channel.ldlj.controller;

import com.alibaba.fastjson.JSONObject;
import com.shuyuan.judd.client.constants.ChannelConstants;
import com.shuyuan.judd.client.model.request.MerchantBindCardOrderRequest;
import com.shuyuan.judd.client.model.request.UploadMaterialRequest;
import com.shuyuan.judd.client.model.request.portal.RegisterMerchant2ChannelRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import spring.shuyuan.judd.base.model.Response;
import spring.shuyuan.judd.base.utils.RandomUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kevin
 * description: 商户入网
 * date: 2018/11/12 10:35 AM
 */
@Slf4j
@RestController
@RequestMapping("/merchant")
@Api(tags = "商户入网、绑定银行卡、余额查询操作。")
public class MerchantControllerMock {


    /**
     * 个人入网
     */
    @PostMapping("/register/person")
    @ResponseBody
    @ApiOperation(value = " 个人调用联动入网,map.put(ChannelConstants.MERCHANT_CHANNEL_NO, resultMap.getData().get(\"user_id\").toString());")
    public Response<Map<String, String>> registerPersonal(@RequestBody RegisterMerchant2ChannelRequest req) {
        log.info("req: {}",JSONObject.toJSONString(req));
        //获取个人入网提交结果
        Response<Map<String, String>> res;
        try {
            //mock code
            Map<String, String> map = new HashMap<>();
            map.put(ChannelConstants.MERCHANT_CHANNEL_NO, "LDLJ-person-"+ RandomUtils.generateRandomString(7));
            //设置状态入网成功，即审核成功
            res = Response.createSuccess(map);
            log.info("merchantService.registerCompanyMerchant(jsonStr):result->{}", JSONObject.toJSONString(res));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("channel-ldlj->register/personal,errorMessage:{}", e.getMessage());
            return Response.createNativeFail(e.getMessage());
        }
        return res;
    }

    /**
     * 个体入网
     */
    @PostMapping("/register/individual")
    @ResponseBody
    @ApiOperation(value = "个体调用联动优势入网, map.put(ChannelConstants.MERCHANT_CHANNEL_NO, resultMap.getData().get(\"user_id\").toString());")
    public Response<Map<String, String>> registerIndividual(@RequestBody RegisterMerchant2ChannelRequest req) throws Exception {
        log.info("req: {}",JSONObject.toJSONString(req));
        //获取个体入网提交结果
        Response<Map<String, String>> res;
        try {
            //submitResult = merchantService.registerPersonalMerchant(req);
            //mock code
            Map<String, String> map = new HashMap<>();
            map.put(ChannelConstants.MERCHANT_CHANNEL_NO, "LDLJ-individual-"+ RandomUtils.generateRandomString(7));
            //设置状态入网成功，即审核成功
            res = Response.createSuccess(map);
            log.info("merchantService.registerCompanyMerchant(jsonStr):result->{}", JSONObject.toJSONString(res));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("channel-ldlj->register/individual,errorMessage:{}", e.getMessage());
            return Response.createNativeFail(e.getMessage());
        }
        return res;
    }

    /**
     * 企业入网
     */
    @PostMapping("/register/company")
    @ResponseBody
    @ApiOperation(value = "企业入网,map.put(ChannelConstants.MERCHANT_CHANNEL_NO, resultMap.getData().get(\"user_id\").toString());\n" +
            "            map.put(ChannelConstants.P_AGREEMENT_ID, resultMap.getData().get(\"p_agreement_id\").toString());")
    public Response<Map<String, String>> registerCompany(@RequestBody RegisterMerchant2ChannelRequest req) {
        log.info("req: {}",JSONObject.toJSONString(req));
        //获取企业入网提交结果
        Response<Map<String, String>> res;
        try {
            //submitResult = merchantService.registerPersonalMerchant(merchant2ChannelRequest);
            //mock code
            Map<String, String> map = new HashMap<>();
            map.put(ChannelConstants.MERCHANT_CHANNEL_NO, "LDLJ-company-"+ RandomUtils.generateRandomString(7));
            map.put(ChannelConstants.P_AGREEMENT_ID, "ldlj-p-agreement-id-"+ RandomUtils.generateRandomString(7));
            //设置状态入网成功，即审核成功
            res = Response.createSuccess(map);
            log.info("merchantService.registerCompanyMerchant(jsonStr):result->{}", JSONObject.toJSONString(res));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("channel-ldlj->register/company,errorMessage:{}", e.getMessage());
            return Response.createNativeFail(e.getMessage());
        }
        return res;
    }

    /**
     * 企业资质审核提交,通知联动审核
     */
    @PostMapping("/register/uploadMaterials")
    @ApiOperation(value = "企业资质审核提交,通知联动审核, @return Response.createSuccess()")
    public Response<String> uploadMaterials(@RequestBody UploadMaterialRequest req) {
        log.info("req: {}",JSONObject.toJSONString(req));
        Response<String> uploadResult;
        try {
            //uploadResult = merchantService.uploadMaterials(req);
            // mock code
            uploadResult =  Response.createSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("channel-ldlj->->/register/uploadMaterials,errorMessage:{}", e.getMessage());
            return Response.createNativeFail(e.getMessage());
        }
        return uploadResult;
    }

    /**
     * 绑卡获取短信验证码
     */
    @PostMapping("/bindCard/order")
    @ApiOperation(value = "绑卡第一步获取验证码，response.setData(String.valueOf(dataMap.get(\"trade_no\")));")
    Response<String> bindMerchantCardOrder(@RequestBody MerchantBindCardOrderRequest req) {
        log.info("bindMerchantCardOrder,requestBody->{},{}", JSONObject.toJSONString(req), System.currentTimeMillis());
        Response<String> response;
        try {
            //reponse = merchantService.bindMerchantCardOrder(merchantBindCardOrderRequest);
            response = Response.createSuccess();
            response.setData("trade_no"+RandomUtils.generateRandomString(13));
            response.setMsg("验证码已发送");
            log.info("merchantService.bindMerchantCardOrder(merchantBindCardOrderModel):result->{},{}", JSONObject.toJSONString(response), System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("merchantService.bindMerchantCardOrder(merchantBindCardOrderModel),errorMessage:{}", e.getMessage());
            return Response.createNativeFail(e.getMessage());
        }
        return response;
    }

    /**
     * 绑定银行卡提交
     */
    @PostMapping("/bindCard/confirm")
    @ApiOperation(value = "绑卡第二步，提交短信验证码，确认绑卡，@return map.put(ChannelResponseConstants.P_AGREEMENT_ID, String.valueOf(dataMap.get(\"p_agreement_id\")))")
    Response<Map<String, String>> bindCardConfirm(@RequestBody MerchantBindCardOrderRequest req) {
        log.info("bindMerchantCardSubmit,requestBody->{},{}", JSONObject.toJSONString(req), System.currentTimeMillis());
        Response<Map<String, String>> response;
        try {
            // response = merchantService.bindCardConfirm(req);
            // mock code
            Map<String, String> map = new HashMap<>();
            map.put(ChannelConstants.P_AGREEMENT_ID, "ldlj-p-agreement-id-"+ RandomUtils.generateRandomString(7));
            response = Response.createSuccess(map);
            log.info("merchantService.bindMerchantCardSubmit(req):result->{},{}", JSONObject.toJSONString(response), System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("merchantService.bindMerchantCardSubmit(req),errorMessage:{}", e.getMessage());
            return Response.createNativeFail(e.getMessage());
        }
        return response;
    }

}
