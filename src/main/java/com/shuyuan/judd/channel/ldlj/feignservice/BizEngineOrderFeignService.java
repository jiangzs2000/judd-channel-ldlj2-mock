package com.shuyuan.judd.channel.ldlj.feignservice;

import com.shuyuan.judd.channel.ldlj.config.constants.ServiceConstants;
import com.shuyuan.judd.client.model.order.WithdrawOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.shuyuan.judd.base.model.Response;

@FeignClient(value = ServiceConstants.BIZ_ENGINE_SERVICE_NAME, path = "/order", decode404 = true)
public interface BizEngineOrderFeignService {
    @PostMapping("/getWithdrawOrder")
     Response<WithdrawOrder> getWithdrawOrder(@RequestParam(name = "orderNo") String orderNo);
}
