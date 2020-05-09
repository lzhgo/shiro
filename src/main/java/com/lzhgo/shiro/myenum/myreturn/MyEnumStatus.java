package com.lzhgo.shiro.myenum.myreturn;

/**
 *
 * @Description: 服务端状态
 */
public enum MyEnumStatus {

	SUCCESS("200", "成功"),
	METHOD_ERROR("500", "后端异常"),
	FAIL("204", "失败"),
	NOT_FOUND("404", "查找不到页面"),
	NOT_LOGIN("403","未登录"),
	UNAUTHORIZED("401","未授权"),
	RUN_TIME_EXCEPTION("500","运行时异常"),
	NULL_POINTER_EXCEPTION("500","空指针"),
	;

	public final String type;
	public final String content;

	MyEnumStatus(String type, String content){
		this.type = type;
		this.content = content;
	}
	public static String getContentByType(String type){
		for(MyEnumStatus item:values()){
			if(item.type==type){
				return item.content;
			}
		}
		return "";
	}
	public String getType() {
		return type;
	}
}
