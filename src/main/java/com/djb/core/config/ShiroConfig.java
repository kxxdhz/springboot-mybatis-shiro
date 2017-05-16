package com.djb.core.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.djb.core.ShiroDbRealm;

@Configuration
public class ShiroConfig {

	
	@Bean(name = "shiroDbRealm")
	public ShiroDbRealm getShiroRealm(MemoryConstrainedCacheManager memoryCacheManager) {
		ShiroDbRealm dbRealm = new ShiroDbRealm();
		dbRealm.setAuthenticationCachingEnabled(true);
		dbRealm.setAuthorizationCachingEnabled(true);
		dbRealm.setCachingEnabled(true);
		dbRealm.setCacheManager(memoryCacheManager);
		return dbRealm;
	}

	@Bean(name="memoryCacheManager")
	public MemoryConstrainedCacheManager memoryCacheManager() {
		return new MemoryConstrainedCacheManager();
	}
	@Bean(name="sessionDAO")
	public SessionDAO sessionDAO() {
		return new MemorySessionDAO();
	}
	
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager(SessionDAO sessionDAO,MemoryConstrainedCacheManager memoryCacheManager) {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionDAO(sessionDAO);
//		sessionManager.setGlobalSessionTimeout(30 * 60 * 1000);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setCacheManager(memoryCacheManager);
		return sessionManager;
	}
	
	@Bean(name="lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
	    daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager defaultWebSecurityManager(ShiroDbRealm shiroDbRealm,DefaultWebSessionManager sessionManager,MemoryConstrainedCacheManager memoryCacheManager) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(shiroDbRealm);
		defaultWebSecurityManager.setSessionManager(sessionManager);
		defaultWebSecurityManager.setCacheManager(memoryCacheManager);
		return defaultWebSecurityManager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;	
	}

//	@Bean(name="shiroFilter")
//	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		Map<String, String> filterChainMap =  new LinkedHashMap<String, String>();
//		filterChainMap.put("/", "anon");
//		filterChainMap.put("/login", "anon");
//		filterChainMap.put("/demo/*", "anon");
//		filterChainMap.put("/user/*", "anon");
//		filterChainMap.put("/logout", "logout");
//		filterChainMap.put("/**", "authc");
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
//		shiroFilterFactoryBean.setLoginUrl("/login");
//		shiroFilterFactoryBean.setSuccessUrl("/success");
//		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
//		return shiroFilterFactoryBean;
//	}
	
	@Bean(name="shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager, ShiroAutoconfig config) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, String> filterChainMap =  new LinkedHashMap<String, String>();
		for (String path : config.getFilter()){
			if(path!=null&&!"".equals(path)){
				String[] kv = path.split("=");
				filterChainMap.put(kv[0].trim(), kv[1].trim());
			}
		}
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
		shiroFilterFactoryBean.setLoginUrl(config.getLoginUrl());
		shiroFilterFactoryBean.setSuccessUrl(config.getSuccessUrl());
		shiroFilterFactoryBean.setUnauthorizedUrl(config.getUnauthorizedUrl());
		return shiroFilterFactoryBean;
	}
	
}
