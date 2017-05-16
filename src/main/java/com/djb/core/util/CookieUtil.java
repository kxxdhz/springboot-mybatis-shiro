package com.djb.core.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	/**
	 * 同域
	 * @param response
	 */
	public static void createCookie(HttpServletResponse response){
		Cookie cookie=new Cookie("ssocookie", "sso");
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static boolean checkCookie(HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("ssocookie") && cookie.getValue().equals("sso")){
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 跨域
	 * @param response
	 */
	public static void createCookieCrossDomain(HttpServletResponse response){
		Cookie cookie=new Cookie("ssocookie", "sso");
		cookie.setDomain(".sso.com");
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static boolean checkCookieCrossDomain(String cookieName,String cookieValue){
		if(cookieName.equals("ssocookie") && cookieValue.equals("sso")){
			return true;
		}
		return false;
	}

}
