package com.djb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.djb.core.util.Result;
import com.djb.core.util.Status;

/**
 * 登录
 * @author lvpeng
 * @date 2016年8月3日下午6:11:29
 */
@Controller
public class LoginController {

	@RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Result login(String username,String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		token.setRememberMe(false);
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
//				return "redirect:/success";
				return Result.okMsg();
			}
		} catch (UnknownAccountException e) {// 此用户不存在，请注册后再登录
			token.clear();
			return Result.fail(2,"用户不存在");
		} catch (AuthenticationException e) {// 密码错误
			token.clear();
			return Result.fail(2,"密码错误");
		}
		return Result.fail(1,"操作失败");
	}
	
	@RequestMapping(value = "/notlogin", method = RequestMethod.GET)
	@ResponseBody
	public Result notlogin() {
		return Result.fail(Status.ER_NOT_LOGIN, Status.ER_NOT_LOGIN_MSG);//未登录
	}
	
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	@ResponseBody
	public Result unauthorized() {
		return Result.fail(Status.ER, "无权限");
	}
	
}
