package com.lzhgo.shiro.mapper;


import com.lzhgo.shiro.domain.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lzh
 * @date 2020/2/24 - 22:32
 */
public interface PrimissionMapper {

    List<Map<String, String>> selectRole(@Param("uiId") int uiId);

    List<Map<String, String>> selectPerms(UserVO userVO);
}
