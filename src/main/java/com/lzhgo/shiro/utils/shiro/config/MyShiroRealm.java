package com.lzhgo.shiro.utils.shiro.config;

import com.lzhgo.shiro.domain.vo.UserVO;
import com.lzhgo.shiro.mapper.PrimissionMapper;
import com.lzhgo.shiro.mapper.UserInfoMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lzh
 * @date 2020/2/23 - 18:00
 */
public class MyShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

     @Resource
     private UserInfoMapper userMapper;
     @Resource
     private PrimissionMapper primissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println("===================权限授权==================");
        //查询权限
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        List<Map<String, String>> permsList = this.primissionMapper.selectPerms(userVO); //根据用户id 查询出权限列表 我这里返回的是map
        if (permsList.size() != 0) {
            Set<String> permsSet = new HashSet<>();
            for (Map<String, String> perms : permsList) {
                permsSet.add(perms.get("uirp_name")); // 权限名称 uirp_name需要更改为自己数据库的权限名称
            }
            info.addStringPermissions(permsSet); // 添加权限
        }
        return info;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("===================权限认证==================");
        // 获取当前用户
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        UserVO userVO = new UserVO();
        userVO.setUiAccount(userToken.getUsername()); // 添加账号
        List relist = this.userMapper.selectUserInfoReList(userVO); // 判断账号是否存在
        if (relist.size() == 0) {
            return null;
        }
        UserVO currentUser = (UserVO)relist.get(0);

        return new SimpleAuthenticationInfo(currentUser, currentUser.getUiPwd(), "");
    }
}
