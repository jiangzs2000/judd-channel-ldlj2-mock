package com.shuyuan.judd.channel.ldlj.controller;

import com.alibaba.fastjson.JSONObject;
import com.shuyuan.judd.client.model.request.channel.payment.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.shuyuan.judd.base.model.Response;
import spring.shuyuan.judd.base.utils.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/pay")
@Api(tags = "渠道支持的支付交易")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @ApiOperation(value = "主动扫码支付")
    @PostMapping("/scanPay")
    public Response<ScanPaymentResponse> scanPay(@RequestBody ScanPaymentRequest req) throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        ScanPaymentResponse r = new ScanPaymentResponse();
        r.setOrderNo(req.getTradeNo());
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        Response<ScanPaymentResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "被动扫码支付")
    @PostMapping("/beScanPay")
    public Response<BeScanPaymentResponse> beScanPay(@RequestBody BeScanPaymentRequest req) throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        BeScanPaymentResponse r = new BeScanPaymentResponse();
        r.setOrderNo(req.getTradeNo());
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(req.getAmount());
        r.setSettleAmt(BigDecimal.valueOf(req.getAmount()).multiply(BigDecimal.valueOf(0.997)).setScale(0, RoundingMode.HALF_UP).longValueExact());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(),"yyyyMMdd"));
        Response<BeScanPaymentResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "微信公众号支付, 可能支付宝也可以，待验证")
    @PostMapping("/officialAccountPay")
    public Response<OfficialAccountPaymentResponse> officialAccountPay(@RequestBody OfficialAccountPaymentRequest req) throws InvocationTargetException, IllegalAccessException {
        log.info("req: {}",JSONObject.toJSONString(req));
        OfficialAccountPaymentResponse r = new OfficialAccountPaymentResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(req.getAmount());
        r.setSettleAmt(BigDecimal.valueOf(req.getAmount()).multiply(BigDecimal.valueOf(0.997)).setScale(0, RoundingMode.HALF_UP).longValueExact());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(),"yyyyMMdd"));
        r.setPayType("WECHAT");
        r.setOpenid("openid");
        r.setAppid("appid");
        r.setPrepayId("prepay_id");
        r.setTimeStamp("time_stamp");
        r.setNonceStr("nonce_str");
        r.setPaySignType("pay_sign_type");
        r.setPaySign("pay_sign");

        Response<OfficialAccountPaymentResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "小程序支付")
    @PostMapping("/appletPay")
    public Response<AppletPaymentResponse>  appletPay(@RequestBody AppletPaymentRequest req) throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        AppletPaymentResponse r = new AppletPaymentResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(req.getAmount());
        r.setSettleAmt(BigDecimal.valueOf(req.getAmount()).multiply(BigDecimal.valueOf(0.997)).setScale(0, RoundingMode.HALF_UP).longValueExact());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(),"yyyyMMdd"));
        r.setPayType("WECHAT");
        r.setOpenid("openid");
        r.setAppid("appid");
        r.setPrepayId("prepay_id");
        r.setTimeStamp("time_stamp");
        r.setNonceStr("nonce_str");
        r.setPaySignType("pay_sign_type");
        r.setPaySign("pay_sign");
        Response<AppletPaymentResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "微信、支付宝app支付")
    @PostMapping("/appPay")
    public Response<AppPaymentResponse> appPay(@RequestBody AppPaymentRequest req) throws InvocationTargetException, IllegalAccessException {
        log.info("req: {}",JSONObject.toJSONString(req));
        AppPaymentResponse r = new AppPaymentResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(req.getAmount());
        r.setOrderNo(req.getTradeNo());
        r.setPayTradeNo(UUID.randomUUID().toString().replace("_", ""));
        r.setPaySign("wertyuiopsdfghjkl;'wedfgbnzxdfgyui/lwdfbjklp[");
        Response<AppPaymentResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "快捷支付获取验卡要素")
    @PostMapping("/fastpay/fastPayGetVerifyElements")
    public Response<FastPayGetVeriElementsResponse> fastPayGetVerifyElements(@RequestBody FastPayGetVeriElementsRequest req) throws Exception{
        log.info("req: {}",JSONObject.toJSONString(req));
        FastPayGetVeriElementsResponse r = new FastPayGetVeriElementsResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setCardType("DEBITCARD");
        r.setBankCode("ICBC");
        r.setPayElements("['id','cardno']");
        Response<FastPayGetVeriElementsResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "快捷支付下发验证码")
    @PostMapping("/fastpay/fastPayGetVerifyCode")
    public Response<FastPayGetVerifyCodeResponse> fastPayGetVerifyCode(@RequestBody FastPayGetVerifyCodeRequest req) throws Exception {
        log.info("req: {}",JSONObject.toJSONString(req));
        FastPayGetVerifyCodeResponse r = new FastPayGetVerifyCodeResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        Response<FastPayGetVerifyCodeResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "快捷支付确认支付")
    @PostMapping("/fastPayConfirm")
    public Response<FastPayConfirmResponse> fastPayConfirm(@RequestBody FastPayConfirmRequest req) throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        FastPayConfirmResponse r = new FastPayConfirmResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(req.getAmount());
        r.setSettleAmt(BigDecimal.valueOf(req.getAmount()).multiply(BigDecimal.valueOf(0.997)).setScale(0, RoundingMode.HALF_UP).longValueExact());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(),"yyyyMMdd"));
        r.setPAgreementId(UUID.randomUUID().toString().replace("_",""));
        r.setBankCode("ICBC");
        Response<FastPayConfirmResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "委托协议支付签约申请")
    @PostMapping("/entrustPayEngage")
    Response<EntrustPayEngageResponse> entrustPayEngage(@RequestBody EntrustPayEngageRequest req) throws Exception {
        log.info("req: {}",JSONObject.toJSONString(req));
        EntrustPayEngageResponse r = new EntrustPayEngageResponse();
        r.setTradeNo(req.getOrder_no());
        Response<EntrustPayEngageResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "委托协议支付签约确认")
    @PostMapping("/entrustPayEngageConfirm")
    Response<EntrustPayEngageConfirmResponse> entrustPayEngageConfirm(@RequestBody EntrustPayEngageConfirmRequest req)  throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        EntrustPayEngageConfirmResponse r = new EntrustPayEngageConfirmResponse();
        r.setPAgreementId(UUID.randomUUID().toString().replace("_",""));
        r.setBankCode("ICBC");
        Response<EntrustPayEngageConfirmResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "委托协议支付")
    @PostMapping("/entrustPay")
    Response<EntrustPayResponse> entrustPay(@RequestBody EntrustPayRequest req)  throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        EntrustPayResponse r = new EntrustPayResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(req.getAmount());
        r.setSettleAmt(BigDecimal.valueOf(req.getAmount()).multiply(BigDecimal.valueOf(0.997)).setScale(0, RoundingMode.HALF_UP).longValueExact());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(),"yyyyMMdd"));
        Response<EntrustPayResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "余额支付")
    @PostMapping("/balancePay")
    Response<BalancePayResponse> balancePay(@RequestBody BalancePayRequest req)  throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        BalancePayResponse r = new BalancePayResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(req.getAmount());
        r.setSettleAmt(BigDecimal.valueOf(req.getAmount()).multiply(BigDecimal.valueOf(0.997)).setScale(0, RoundingMode.HALF_UP).longValueExact());
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(),"yyyyMMdd"));
        Response<BalancePayResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "网银支付")
    @PostMapping("/ebankPay")
    public Response<EbankPaymentResponse> ebankPay(@RequestBody EbankPaymentRequest req) throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        EbankPaymentResponse r = new EbankPaymentResponse();
        Response<EbankPaymentResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }

    @ApiOperation(value = "支付结果查询")
    @PostMapping("/paymentQuery")
    public Response<PaymentQueryResponse> paymentQuery(PaymentQueryRequest req) throws InvocationTargetException, IllegalAccessException{
        log.info("req: {}",JSONObject.toJSONString(req));
        PaymentQueryResponse r = new PaymentQueryResponse();
        r.setTradeNo(req.getTradeNo());
        r.setTrace(req.getTrace());
        r.setAmount(10000L);
        r.setSettleAmt(9970L);
        r.setMerCheckDate(DateUtils.getNextFormatDate(new Date(),"yyyyMMdd"));
        r.setState("1");
        Response<PaymentQueryResponse> res = Response.createSuccess(r);
        log.info("res: {}", JSONObject.toJSONString(res));
        return res;
    }
}
