package com.djb.core.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * shiro配置信息
 * @author lvpeng
 * @date 2016年8月3日下午5:13:47
 */
@Component
@ConfigurationProperties(prefix="spring.shiro")
public class ShiroAutoconfig {

	List<String> filter = new ArrayList<String>();
	
	private String loginUrl;
	private String successUrl;
	private String unauthorizedUrl;
	public List<String> getFilter() {
		return filter;
	}
	public void setFilter(List<String> filter) {
		this.filter = filter;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getSuccessUrl() {
		return successUrl;
	}
	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}
	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}
	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}
	
	
}
