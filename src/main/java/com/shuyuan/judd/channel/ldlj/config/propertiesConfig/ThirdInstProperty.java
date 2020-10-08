package com.shuyuan.judd.channel.ldlj.config.propertiesConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Sting
 * create 2018/11/25

 **/
@Component
public class ThirdInstProperty {
    //商户号(联动分发给平台唯一标志)
    @Value("${merchant.id}")
    private String merchantNo;

    //联动商户入网统一域名前缀
    @Value("${ldlj.url.prefix}")
    private String ldljUrlPrefix;

    //企业商户入网接口地址
    @Value("${register.company.url}")
    private String registerCompanyUrl;

    //个人商户入网接口地址
    @Value("${register.personal.url}")
    private String registerPersonalUrl;

    @Value("${register.individual.url}")
    private String registerIndividualUrl;

    //子商户资质上传通知接口地址
    @Value("${ldlj.upload.url}")
    private String ldljUploadUrl;


    //申请绑定银行卡接口地址
    @Value("${ldlj.card.bind.url}")
    private String ldljCardBindUrl;
    //申请绑定银行卡确认接口地址
    @Value("${ldlj.bindcard.confirm.url}")
    private String ldljBindCardConfirmUrl;
    //验卡
    @Value("${ldlj.card.verify.url}")
    private String getCardVerifyCodeUrl;
    //验证码验证
    @Value("${ldlj.pay.verify.url}")
    private String payVerifyCode;
    //支付确认
    @Value("${ldlj.pay.confirm.url}")
    private String payConfirm;


    //资质图片下载文件目录
    @Value("${ldlj.download.catalogue}")
    private String ldljDownloadCatalogue;

    //订单创建
    @Value("${ldlj.trade.order.create.url}")
    private String tradeOrderCreate;
    //订单查询
    @Value("${ldlj.trade.order.query.url}")
    private String tradeOrderQuery;
    //支付宝微信公众号支付
    @Value("${ldlj.pay.wechatplatformpay.url}")
    private String payWechatPlatFormPay;
    //微信app支付
    @Value("${ldlj.pay.wxapppay.url}")
    private String payWxAppPay;
    //微信AppId
    @Value("${wechat.official.appid}")
    private String wechatAppid;
    //商户提现
    @Value("${ldlj.pay.member.withdrawal.url}")
    private String payMemberWithdrawal;
    //平台提现
    @Value("${ldlj.pay.withdrawal.url}")
    private String paywithdrawal;
    //提现查询
    @Value("${ldlj.pay.withdrawal.query.url}")
    private String paywithdrawalQuery;
    //交易订单完成(确认完成担保交易)
    @Value("${ldlj.trade.order.finish.url}")
    private String tradeOrderFinish;
    @Value("${ldlj.pay.refund.url}")
    private String payRefundUrl;


    //商户入网回调地址
    @Value("${judd.callback.url}")
    private String juddCallbackUrl;
    //商户资质上传通知回调
    @Value(("${judd.uploadNotice.url}"))
    private String juddUploadNoticeUrl;
    //子商户资质校验回调接口地址
    @Value("${judd.audit.url}")
    private String juddAuditUrl;
    //子商户绑卡下单回调地址
    @Value("${judd.card.bindNotice.url}")
    private String juddCardBindNoticeUrl;
    //回调地址
    @Value("${notify.url}")
    private String notifyUrl;


    //惠商回调地址
    @Value("${huishang.notify.url}")
    private String huiShangNotifyUrl;


    //受益户剩余金额
    @Value("${ldlj.balance.query.url}")
    private String merBanlanceQuery;
    //子商户剩余金额
    @Value("${ldlj.member.balance.url}")
    private String memberBanlanceQuery;

    //支付宝公众号支付地址
    @Value("${ldlj.pay.alipayvipcn.url}")
    private String ldljAliPayVipCnUrl;
    //B2B网银 and B2C个人网银支付地址
    @Value("${ldlj.pay.ebankspay.url}")
    private String ldljEbanksPayUrl;

    //集成商商户号
    @Value("${huishang.integration.merchant.id}")
    private String integrationMerchantNo;
    //加签证书 证书名称
    @Value("${huishang.certificate.name}")
    private String certificateName;
    //公众号/小程序支付(创建虚拟订单（业务订单）)
    @Value("${huishang.virtual.pay.creade.order.url}")
    private String virtualPayCreadeOrderUrl;
    //惠商商户号
    @Value("${huishang.merchantNo}")
    private String huishangMerchantNo;

    @Value("${saas.verify_captcha.url}")
    private String saasVerifyCaptchaUrl;

    public String getSaasVerifyCaptchaUrl() {
        return saasVerifyCaptchaUrl;
    }

    public void setSaasVerifyCaptchaUrl(String saasVerifyCaptchaUrl) {
        this.saasVerifyCaptchaUrl = saasVerifyCaptchaUrl;
    }

    public String getJuddUploadNoticeUrl() {
        return juddUploadNoticeUrl;
    }

    public void setJuddUploadNoticeUrl(String juddUploadNoticeUrl) {
        this.juddUploadNoticeUrl = juddUploadNoticeUrl;
    }

    public String getJuddAuditUrl() {
        return juddAuditUrl;
    }

    public void setJuddAuditUrl(String juddAuditUrl) {
        this.juddAuditUrl = juddAuditUrl;
    }

    public String getJuddCallbackUrl() {
        return juddCallbackUrl;
    }

    public void setJuddCallbackUrl(String juddCallbackUrl) {
        this.juddCallbackUrl = juddCallbackUrl;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getLdljUrlPrefix() {
        return ldljUrlPrefix;
    }

    public void setLdljUrlPrefix(String ldljUrlPrefix) {
        this.ldljUrlPrefix = ldljUrlPrefix;
    }

    public String getRegisterCompanyUrl() {
        return registerCompanyUrl;
    }

    public void setRegisterCompanyUrl(String registerCompanyUrl) {
        this.registerCompanyUrl = registerCompanyUrl;
    }

    public String getRegisterPersonalUrl() {
        return registerPersonalUrl;
    }

    public void setRegisterPersonalUrl(String registerPersonalUrl) {
        this.registerPersonalUrl = registerPersonalUrl;
    }

    public String getLdljUploadUrl() {
        return ldljUploadUrl;
    }

    public void setLdljUploadUrl(String ldljUploadUrl) {
        this.ldljUploadUrl = ldljUploadUrl;
    }

    public String getLdljCardBindUrl() {
        return ldljCardBindUrl;
    }

    public void setLdljCardBindUrl(String ldljCardBindUrl) {
        this.ldljCardBindUrl = ldljCardBindUrl;
    }

    public String getLdljBindCardConfirmUrl() {
        return ldljBindCardConfirmUrl;
    }

    public void setLdljBindCardConfirmUrl(String ldljBindCardConfirmUrl) {
        this.ldljBindCardConfirmUrl = ldljBindCardConfirmUrl;
    }

    public String getLdljDownloadCatalogue() {
        return ldljDownloadCatalogue;
    }

    public void setLdljDownloadCatalogue(String ldljDownloadCatalogue) {
        this.ldljDownloadCatalogue = ldljDownloadCatalogue;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeOrderCreate() {
        return tradeOrderCreate;
    }

    public void setTradeOrderCreate(String tradeOrderCreate) {
        this.tradeOrderCreate = tradeOrderCreate;
    }

    public String getTradeOrderQuery() {
        return tradeOrderQuery;
    }

    public void setTradeOrderQuery(String tradeOrderQuery) {
        this.tradeOrderQuery = tradeOrderQuery;
    }

    public String getPayWechatPlatFormPay() {
        return payWechatPlatFormPay;
    }

    public void setPayWechatPlatFormPay(String payWechatPlatFormPay) {
        this.payWechatPlatFormPay = payWechatPlatFormPay;
    }

    public String getGetCardVerifyCodeUrl() {
        return getCardVerifyCodeUrl;
    }

    public void setGetCardVerifyCodeUrl(String getCardVerifyCodeUrl) {
        this.getCardVerifyCodeUrl = getCardVerifyCodeUrl;
    }

    public String getPayVerifyCode() {
        return payVerifyCode;
    }

    public void setPayVerifyCode(String payVerifyCode) {
        this.payVerifyCode = payVerifyCode;
    }

    public String getPayConfirm() {
        return payConfirm;
    }

    public void setPayConfirm(String payConfirm) {
        this.payConfirm = payConfirm;
    }

    public String getWechatAppid() {
        return wechatAppid;
    }

    public void setWechatAppid(String wechatAppid) {
        this.wechatAppid = wechatAppid;
    }

    public String getPayMemberWithdrawal() {
        return payMemberWithdrawal;
    }

    public void setPayMemberWithdrawal(String payMemberWithdrawal) {
        this.payMemberWithdrawal = payMemberWithdrawal;
    }

    public String getPaywithdrawal() {
        return paywithdrawal;
    }

    public void setPaywithdrawal(String paywithdrawal) {
        this.paywithdrawal = paywithdrawal;
    }

    public String getPaywithdrawalQuery() {
        return paywithdrawalQuery;
    }

    public void setPaywithdrawalQuery(String paywithdrawalQuery) {
        this.paywithdrawalQuery = paywithdrawalQuery;
    }

    public String getTradeOrderFinish() {
        return tradeOrderFinish;
    }

    public void setTradeOrderFinish(String tradeOrderFinish) {
        this.tradeOrderFinish = tradeOrderFinish;
    }

    public String getMemberBanlanceQuery() {
        return memberBanlanceQuery;
    }

    public void setMemberBanlanceQuery(String memberBanlanceQuery) {
        this.memberBanlanceQuery = memberBanlanceQuery;
    }

    public String getRegisterIndividualUrl() {
        return registerIndividualUrl;
    }

    public void setRegisterIndividualUrl(String registerIndividualUrl) {
        this.registerIndividualUrl = registerIndividualUrl;
    }

    public String getJuddCardBindNoticeUrl() {
        return juddCardBindNoticeUrl;
    }

    public void setJuddCardBindNoticeUrl(String juddCardBindNoticeUrl) {
        this.juddCardBindNoticeUrl = juddCardBindNoticeUrl;
    }

    public String getIntegrationMerchantNo() {
        return integrationMerchantNo;
    }

    public void setIntegrationMerchantNo(String integrationMerchantNo) {
        this.integrationMerchantNo = integrationMerchantNo;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getVirtualPayCreadeOrderUrl() {
        return virtualPayCreadeOrderUrl;
    }

    public void setVirtualPayCreadeOrderUrl(String virtualPayCreadeOrderUrl) {
        this.virtualPayCreadeOrderUrl = virtualPayCreadeOrderUrl;
    }

    public String getHuishangMerchantNo() {
        return huishangMerchantNo;
    }

    public void setHuishangMerchantNo(String huishangMerchantNo) {
        this.huishangMerchantNo = huishangMerchantNo;
    }

    public String getLdljAliPayVipCnUrl() {
        return ldljAliPayVipCnUrl;
    }

    public void setLdljAliPayVipCnUrl(String ldljAliPayVipCnUrl) {
        this.ldljAliPayVipCnUrl = ldljAliPayVipCnUrl;
    }

    public String getLdljEbanksPayUrl() {
        return ldljEbanksPayUrl;
    }

    public void setLdljEbanksPayUrl(String ldljEbanksPayUrl) {
        this.ldljEbanksPayUrl = ldljEbanksPayUrl;
    }

    public String getPayRefundUrl() {
        return payRefundUrl;
    }

    public void setPayRefundUrl(String payRefundUrl) {
        this.payRefundUrl = payRefundUrl;
    }

    public void setMerBanlanceQuery(String merBanlanceQuery) {
        this.merBanlanceQuery = merBanlanceQuery;
    }

    public String getMerBanlanceQuery() {
        return merBanlanceQuery;
    }

    public String getPayWxAppPay() {
        return payWxAppPay;
    }

    public void setPayWxAppPay(String payWxAppPay) {
        this.payWxAppPay = payWxAppPay;
    }

    public void setHuiShangNotifyUrl(String huiShangNotifyUrl) {
        this.huiShangNotifyUrl = huiShangNotifyUrl;
    }

    public String getHuiShangNotifyUrl() {
        return huiShangNotifyUrl;
    }
}
