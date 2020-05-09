package com.lzhgo.shiro.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lzh
 * @date 2020/2/23 - 19:19
 */
@Data
public class UserVO  implements Serializable {
    /**
     * 主键
     */
    private String uiId;

    /**
     * 用户账号
     */
    private String uiAccount;

    /**
     * 用户密码
     */
    private String uiPwd;

    /**
     * 昵称
     */
    private String uiNick;

    /**
     * 认证id
     */
    private String sessionId;

}
