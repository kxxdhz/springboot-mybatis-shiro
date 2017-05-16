package com.djb.core;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.djb.po.User;
import com.djb.service.UserService;

/**
 * ShiroDbRealm
 * @author lvpeng
 * @date 2016年8月3日下午5:19:50
 */
public class ShiroDbRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		User user=userService.getByUsername(username);
		if (user!=null) {
			return new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getUsername(),user.getRealName()),user.getPassword(),user.getUsername());
		} else {
			 throw new UnknownAccountException(); //如果用户名错误  
		}
	}
	
	
	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = 3675130503936649217L;
		public Long id;
		public String username;
		public String realName;
	
		public ShiroUser(Long id, String username, String realName) {
			this.id = id;
			this.username = username;
			this.realName = realName;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getRealName() {
			return this.realName;
		}
		public void setRealName(String realName) {
			this.realName = realName;
		}
	}

}

