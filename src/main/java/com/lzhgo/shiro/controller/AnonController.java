package com.lzhgo.shiro.controller;

import com.lzhgo.shiro.domain.vo.UserVO;
import com.lzhgo.shiro.service.AnonService;
import com.lzhgo.shiro.utils.currency.ReCall;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lzh
 * @date 2020/2/23 - 18:05
 */
@RestController
@RequestMapping("/anon")
public class AnonController {
    @Autowired
    private AnonService anonServiceImpl;

    @RequestMapping("/login")
    public Object login(@RequestBody UserVO userVO) {
        return this.anonServiceImpl.login(userVO);
    }

    @RequestMapping("/get")
    public UserVO get() {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        return new UserVO();
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest httpServletRequest) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ReCall.reCurrency(1, null, null);
    }
}
