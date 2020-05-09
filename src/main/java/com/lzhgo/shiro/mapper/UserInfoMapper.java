package com.lzhgo.shiro.mapper;


import com.lzhgo.shiro.domain.vo.UserVO;

import java.util.List;

/**
 * @author lzh
 * @date 2020/2/24 - 17:59
 */
public interface UserInfoMapper {
    List selectUserInfoReList(UserVO userVO);
}
