package com.example.web;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by heyao on 2017/3/8.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 负责处理/index.html的请求
     */
    @RequestMapping(value = "/index.html")
    public String loginString() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand command) {

        boolean hasMatchUser = userService.hasMatchUser(command.getUserName(), command.getPassword());
        if (!hasMatchUser) {
            return new ModelAndView("login", "error", "用户名或密码错误");
        } else {
            User user = userService.findUserByUserName(command.getUserName());
            user.setLastIp(request.getLocalAddr());
            System.out.println("localName:"+request.getLocalName());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setLastVisit(dateFormat.format(new Date()));
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }

}
