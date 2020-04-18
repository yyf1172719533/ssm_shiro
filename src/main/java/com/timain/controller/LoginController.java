package com.timain.controller;

import com.timain.pojo.ActiverUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 15:12
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录
     * @param username
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String pwd, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, pwd);
        try {
            subject.login(token);
            System.out.println("登录成功");
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            session.setAttribute("user", activerUser.getUser());
            return "redirect:/user/toUserManager.action";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/index.jsp";
        }
    }
}
