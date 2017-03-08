package com.example.service;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by heyao on 2017/3/7.
 */

@ContextConfiguration("classpath*:spring-config.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser() {
        boolean matchUser1 = userService.hasMatchUser("admin", "123456");
        boolean matchUser2 = userService.hasMatchUser("root", "123456");
        assertTrue(matchUser1);
        assertTrue(!matchUser2);
    }

    @Test
    public void findUserByName() {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserId(), 1);
        assertEquals(user.getCredits(), 5);
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void addLoginLog() {
        User user = userService.findUserByUserName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");

        SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());

        user.setLastVisit(date);
//        assertEquals(user.toString(),"");
        userService.loginSuccess(user);

        User admin = userService.findUserByUserName("admin");
//        assertEquals(admin.getCredits(), 10);
//        assertEquals(admin.getLastIp(), "127.0.0.1");
        assertEquals(admin.toString(), "");
    }


}
