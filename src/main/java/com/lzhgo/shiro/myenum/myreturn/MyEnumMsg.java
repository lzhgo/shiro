package com.lzhgo.shiro.myenum.myreturn;

/**
 * @Description: 服务端错误类型
 */
public enum MyEnumMsg {

    LOGIN_SUCCESS(1, "登陆成功"),
    LOGIN_FAIL(2, "登陆失败,用户名或密码错误"),
    SELECT_SUCCESS(3, "查询成功"),
    SELECT_FAIL(4, "查询失败"),
    SELECT_NULL(5, "查询数据为空"),
    INSERT_SUCCESS(6, "添加成功"),
    INSERT_FAIL(7, "添加失败"),
    UPLOAD_SUCCESS(8, "更新上传成功")
    ;

    public final Integer type;
    public final String content;

    MyEnumMsg(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}
