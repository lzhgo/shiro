package com.lzhgo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzh
 * @date 2020/5/9 - 12:50
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @RequiresPermissions("news:insert") // 必须拥有此权限
    @RequestMapping("/testPermission")
    public Object testPermission() {
        return "拥有权限";
    }
}
