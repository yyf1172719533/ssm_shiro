package com.timain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 15:26
 */
@RequestMapping("/user")
@Controller
public class UserController {

    /**
     * 跳转到用户管理页面
     * @return
     */
    @RequestMapping("toUserManager")
    public String toUserManager() {
        return "list";
    }

    @RequestMapping("query")
    @ResponseBody
    public Map<String, Object> query() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","query");
        return map;
    }

    @RequestMapping("add")
    @ResponseBody
    public Map<String, Object> add() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","add");
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> update() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","update");
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> delete() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","delete");
        return map;
    }

    @RequestMapping("export")
    @ResponseBody
    public Map<String, Object> export() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","export");
        return map;
    }
}
