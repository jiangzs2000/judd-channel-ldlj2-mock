package com.shuyuan.judd.channel.ldlj.mermock;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.shuyuan.judd.base.model.Response;

import java.util.Map;
@Slf4j
@Api(tags = "模拟平台商户接收通知")
@RestController
@RequestMapping("/mermock")
public class PlatMerCallbackController {
    @RequestMapping("/registrationCallback")
    public Response<String> registrationCallback(@RequestBody Map<String, String> reqMap){
        log.info("registrationCallback: {}",reqMap.toString());
        return Response.createSuccess("收到通知");
    }

    @RequestMapping("/materialReviewCallback")
    public Response<String> materialReviewCallback(@RequestBody Map<String, String> reqMap){
        log.info("materialReviewCallback: {}",reqMap.toString());
        return Response.createSuccess("收到通知");
    }

    @RequestMapping("/paymentCallback")
    public Response<String> paymentCallback(@RequestBody Map<String, String> reqMap){
        log.info("paymentCallback: {}",reqMap.toString());
        long now = System.currentTimeMillis();
        if(now%3 == 0){
            throw new RuntimeException();
        }
        return Response.createSuccess("收到通知");
    }

    @RequestMapping("/refundCallback")
    public Response<String> refundCallback(@RequestBody Map<String, String> reqMap){
        log.info("refundCallback: {}",reqMap.toString());
        return Response.createSuccess("收到通知");
    }

    @RequestMapping("/withdrawCallback")
    public Response<String> withdrawCallback(@RequestBody Map<String, String> reqMap){
        log.info("withdrawCallback: {}",reqMap.toString());
        return Response.createSuccess("收到通知");
    }
}
