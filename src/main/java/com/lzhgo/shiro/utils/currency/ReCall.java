package com.lzhgo.shiro.utils.currency;

import com.google.gson.Gson;
import com.lzhgo.shiro.myenum.myreturn.MyEnumMsg;
import com.lzhgo.shiro.myenum.myreturn.MyEnumStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzh
 * @date 10/16/2019 - 2:24 PM
 * <p>
 * 针对代码
 * Ctrl+Shift+Up/Down，向上/下移动语句
 * ctrl+alt+enter 向上插入一行
 * ctrl+h 查看类结构
 * shift+f6 重构变量 文件名等
 * Ctrl+Shift+U，大小写转化
 * Ctrl+”+/-”，当前方法展开、折叠
 * Ctrl+Shift+”+/-”，全部展开、折叠
 * Ctrl+Shift+J，整合两行
 * 最近粘贴过的代码
 * <p>
 * 生成操作
 * Alt＋Insert 可以生成构造器/Getter/Setter等
 * alt+enter 导包 生成返回值
 * ctrl + o 生成重写方法
 * ctrl+alt+f 成员提取到全局
 * 全局操作
 * ctrl+alt+shif+u 查看类图
 * ctrl+p 查看参数类型
 * ctrl+e 打开最近修改的文件
 * Ctrl+Shift+F4，关闭活动选项卡
 * Ctrl+F4，关闭当前
 * 定位高亮代码 F2或者shift+F2
 * 子类或子方法实现 ctrl + alt + B
 * <p>
 * 生成语句
 * iter
 * itar
 * fori
 * list.for
 * list.forr
 * ifn ==null
 * inn !=null
 */
public class ReCall {

    /**
     * 不分页封装
     *
     * @param reMapList
     * @param msg
     * @return
     */
    public static String reSelectMapList(List<Map> reMapList, String msg) {
        Gson gson = new Gson();
        Map data = new HashMap();
        String status = "0";
        List relist = new ArrayList();
        if (null == reMapList) {
            reMapList = new ArrayList<>();
        }
        relist = ResultMap.toReplaceKeyLowList(reMapList);
        /*for (Map map : reMapList) {
            map = ResultMap.toReplaceKeyLow(map);
            relist.add(map);
        }*/
        if (0 != relist.size()) {
            if (null == msg) {
                msg = MyEnumMsg.SELECT_SUCCESS.content;
            }
            status = MyEnumStatus.SUCCESS.type;
        } else {
            if (null == msg) {
                msg = MyEnumMsg.SELECT_NULL.content;
            }
            status = MyEnumStatus.FAIL.type;
        }
        data.put("status", status);
        data.put("msg", msg);
        data.put("data", relist);
        return gson.toJson(data);
    }

    /**
     * 单map分装
     *
     * @param reMapList
     * @param msg
     * @return
     */
    public static String reSelectMapListOne(List<Map> reMapList, String msg) {
        Gson gson = new Gson();
        Map reMap = new HashMap();
        String status = "0";
        List relist = new ArrayList();
        Object data = null;
        if (null == reMapList) {
            reMapList = new ArrayList<>();
        }
        relist = ResultMap.toReplaceKeyLowList(reMapList);
        if (0 != relist.size()) {
            if (null == msg) {
                msg = MyEnumMsg.SELECT_SUCCESS.content;
            }
            status = MyEnumStatus.SUCCESS.type;
            data = relist.get(0);

        } else {
            if (null == msg) {
                msg = MyEnumMsg.SELECT_NULL.content;
            }
            status = MyEnumStatus.FAIL.type;
        }
        reMap.put("status", status);
        reMap.put("msg", msg);
        reMap.put("data", data);
        return gson.toJson(reMap);
    }


    /**
     * 通用返回参数
     *
     * @param data
     * @return
     */
    public static String reCurrency(Object data, String msg, String status) {
        Map map = new HashMap();
        Gson gson = new Gson();
        if (status == null) {
            if (data == null) {
                status = MyEnumStatus.FAIL.type;
            } else {
                status = MyEnumStatus.SUCCESS.type;
            }
        }
        if (msg == null) {
            msg = MyEnumStatus.getContentByType(status);
        }
        map.put("status", status);
        map.put("data", data);
        map.put("msg", msg);
        return gson.toJson(map);
    }
}
