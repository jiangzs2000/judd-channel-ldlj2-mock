package com.shuyuan.judd.channel.ldlj.model;

import spring.shuyuan.judd.base.model.Response;
import spring.shuyuan.judd.base.model.TraceIdHelper;

import java.util.Map;
import com.umpay.dto.UMFResponse;

public class UMFResponseModel<T> extends Response {
    private Map sendData;

    public Map getSendData() {
        return sendData;
    }

    public void setSendData(Map sendData) {
        this.sendData = sendData;
    }

    public static <T extends Object> UMFResponseModel<T> createSuccessIsBackData(UMFResponse.Message<Map> retMessage) {
        UMFResponseModel<T> result = new UMFResponseModel<T>();
        result.setCode(Code.SUCCESS.getCode());
        result.setSendData(retMessage.getData());
        result.setTraceId(TraceIdHelper.getTraceId());
        return result;
    }

    public static <T> UMFResponseModel<T> createSuccessMapIsBackData(Map<String, String> jsonMap) {
        UMFResponseModel<T> result = new UMFResponseModel();
        result.setCode("0");
        result.setSendData(jsonMap);
        result.setTraceId(TraceIdHelper.getTraceId());
        return result;
    }

    public static <T> UMFResponseModel<T> createUMFProcess(String code, String msg) {
        UMFResponseModel<T> result = new UMFResponseModel();
        result.setCode(code);
        result.setMsg(msg);
        result.setTraceId(TraceIdHelper.getTraceId());
        return result;
    }

    public static <T> UMFResponseModel<T> createUMFFail(String code, String msg) {
        UMFResponseModel<T> result = new UMFResponseModel();
        result.setCode(code);
        result.setMsg(msg);
        result.setTraceId(TraceIdHelper.getTraceId());
        return result;
    }
}
