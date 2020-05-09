# shiro
需要注意几点
1-com.lzhgo.shiro.utils.shiro.config;包下的uiId需要改为对应的用户主键id shiro的配置文件只需要更改此字段
2-yml需要改位自己的mysql redis地址用户名密码
3-controller 通过@RequiresPermissions("")来控制权限
