package com.djb.core.util;

import java.io.Serializable;

/**
 * 接口返回数据封装类
 * @author lvpeng  
 * @date 2016年8月3日 下午5:47:12
 */
public class Result implements Serializable{
	private static final long serialVersionUID = 1L;

	static String result_void = null;
	
	private String msg;
	private int status;
	private Object data;

	public Result(int status,String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public Result() {
		super();
	}

	public Result(Object data) {
		this(Status.OK,Status.OK_MSG, data);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Result [msg=" + msg + ", status=" + status + ", data=" + data + "]";
	}

	public static Result okMsg(){
		return new Result(Status.OK,Status.OK_MSG,result_void);
	}
	
	public static Result okMsg(String msg){
		return new Result(Status.OK,msg,result_void);
	}
	
	public static Result ok(Object data){
		return new Result(Status.OK,Status.OK_MSG,data);
	}
	
	public static  Result ok(String msg, Object data){
		return new Result(Status.OK,msg,data);
	}
	
	public static Result fail(int status){
		return new Result(status,result_void,result_void);
	}
	
	public static Result fail(int status,String msg){
		return new Result(status,msg,result_void);
	}
	
	public static Result fail(int status,String msg, Object data){
		return new Result(status,msg,data);
	}
	
	
}
