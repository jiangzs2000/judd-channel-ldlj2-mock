package com.shuyuan.judd.channel.ldlj.controller;

import com.shuyuan.judd.channel.ldlj.BaseIntegrationTest;
import org.junit.Assert;
import org.junit.Test;

public class InternationalDemoTest extends BaseIntegrationTest {
	
	@Test
	public void zh() {
		Assert.assertEquals("测试", restTemplate.getForEntity( url + "/in/lang?lang=zh_CN", String.class).getBody());
	}
	
	@Test
	public void en() {
		Assert.assertEquals("test", restTemplate.getForEntity( url + "/in/lang?lang=en_US", String.class).getBody());
	}
}
