package com.djb.core.util;

/**
 * 接口返回数据状态定义
 * @author lvpeng  
 * @date 2016年8月3日 下午5:47:46
 */
public interface Status {
	int OK = 0;
	String OK_MSG = "操作成功";
	
	int ER = 1;
	String ER_MSG = "操作失败";
	
	int ER_LOGIN = 2;
	String ER_LOGIN_MSG = "手机号或密码错误";
	
	int ER_NOT_LOGIN = 3;
	String ER_NOT_LOGIN_MSG = "未登录";
	
	int ER_UNBIND_PHONE = 4;
	String ER_UNBIND_PHONE_MSG = "此手机号未绑定账号";
	
	int ER_UNBIND_EMAIL = 5;
	String ER_UNBIND_EMAIL_MSG = "此邮箱尚未绑定账户";
	
	int ER_PWD_RESET = 6;
	String ER_PWD_RESET_MSG = "密码重置失败，请稍后再试";
	
	int ER_CODE_PAST = 7;
	String ER_CODE_PAST_MSG = "验证码已过期，请重新获取";
	
	int ER_CODE = 8;
	String ER_CODE_MSG = "您输入的验证码错误，请重新输入";
	
	int ER_HAS_BIND_PHONE = 9;
	String ER_HAS_BIND_PHONE_MSG = "该手机号已经注册或绑定，请直接登录";
	
	int ER_HAS_BIND_EMAIL = 10;
	String ER_HAS_BIND_EMAIL_MSG = "该邮箱已绑定其它账号，请更换邮箱";
	
	int ER_USERNAME_USED = 11;
	String ER_USERNAME_USED_MSG = "该账号已有人注册";
	
	int ER_PARAM = 12;
	String ER_PARAM_MSG = "参数错误";
	
	int ER_PWD_EQ = 13;
	String ER_PWD_EQ_MSG = "新密码与原密码相同";
	
	int ER_PWD_NE = 14;
	String ER_PWD_NE_MSG = "原密码输入错误";
	
	int ER_UPLOAD = 15;
	String ER_UPLOAD_MSG = "上传失败，请稍后再试";
	
	int ER_NO_UPDATE = 16;
	String ER_NO_UPDATE_MSG = "无可用更新";
	
	int ER_NEED_PHONE = 17;
	String ER_NEED_PHONE_MSG = "请输入需要绑定的手机号";
	
	int ER_UNREG = 18;
	String ER_UNREG_MSG = "该手机号未注册，请注册后登录";
	
	int ER_KICKOUT = 19;
	String ER_KICKOUT_MSG = "已被踢出";
}
