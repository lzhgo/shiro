package com.lzhgo.shiro.service.impl;

import com.lzhgo.shiro.domain.vo.UserVO;
import com.lzhgo.shiro.myenum.myreturn.MyEnumMsg;
import com.lzhgo.shiro.service.AnonService;
import com.lzhgo.shiro.utils.currency.ReCall;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author lzh
 * @date 2020/2/23 - 19:23
 */
@Service
public class AnonServiceImpl implements AnonService {
    @Override
    public String login(UserVO userVO) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userVO.getUiAccount(), userVO.getUiPwd());
        try {
            subject.login(token);
            // 获取用户信息
            /*Map<String, Object> user = (Map<String, Object>) subject.getPrincipal();
            user.put("session_id", subject.getSession().getId().toString());
            // 获取sessionId
            return ReCall.reCurrency(ResultMap.toReplaceKeyLow(user), null,null);*/
            UserVO userVOPrincipal = (UserVO) subject.getPrincipal();
            userVOPrincipal.setSessionId(subject.getSession().getId().toString());
            return ReCall.reCurrency(userVOPrincipal, null,null);
        } catch (UnknownAccountException e) {
            return ReCall.reCurrency(null, MyEnumMsg.LOGIN_FAIL.content,null);
        } catch (IncorrectCredentialsException e) {
            return ReCall.reCurrency(null, MyEnumMsg.LOGIN_FAIL.content,null);
        }
    }
}
