package com.lzhgo.shiro.service;


import com.lzhgo.shiro.domain.vo.UserVO;

/**
 * @author lzh
 * @date 2020/2/23 - 19:34
 */
public interface AnonService {
    String login(UserVO userVO);
}
