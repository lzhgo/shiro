package com.lzhgo.shiro.myenum.myreturn;

/**
 *
 * @Description: 服务端错误类型
 */
public enum MyEnumMsgParam {

	LOGIN_PARAM(1, "用户名或密码不能为空"),
	;

	public final Integer type;
	public final String content;

	MyEnumMsgParam(Integer type, String content){
		this.type = type;
		this.content = content;
	}

	public Integer getType() {
		return type;
	}
}
