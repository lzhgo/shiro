package com.lzhgo.shiro.myenum.myreturn;

/**
 *
 * @Description: 服务端错误类型
 */
public enum MyEnumError {

	ERROR_ALL(1, "异常类型1-后端有未捕捉异常"),
	NULL_AES(2, "data参数不能为空，必须被aes加密"),
	NULL_PARAM(3,"参数错误类型1--重要参数不能为空"),
	ERROR_PARAM(4,"参数错误类型2--参数转换对象错误，确认参数是否正确"),
	ERROR_MAPPER(5, "异常类型2-mapper错误"),
	NOT_POWER(6,"权限不足"),
	FILE_ERROR(7,"上传错误"),
	DOWN_ERROR(8,"下载异常")
	;

	public final Integer type;
	public final String content;

	MyEnumError(Integer type, String content){
		this.type = type;
		this.content = content;
	}

	public Integer getType() {
		return type;
	}
}
