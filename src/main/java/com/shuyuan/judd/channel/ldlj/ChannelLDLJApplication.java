package com.shuyuan.judd.channel.ldlj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
//@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ChannelLDLJApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ChannelLDLJApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//do something after spring-boot started
	}
	
}