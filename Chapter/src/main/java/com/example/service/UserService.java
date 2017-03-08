package com.example.service;

import com.example.dao.LoginLogDao;
import com.example.dao.UserDao;
import com.example.domain.LoginLog;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 将UserService标注为一个服务层的Bean
 */
@Service
public class UserService {

    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    private void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    private void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password) {
        int count = userDao.getMatchCount(userName, password);
        return count > 0;
    }

    public User findUserByUserName(String name) {
        return userDao.findUserByUserName(name);
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        System.out.println("loginLog:" + loginLog.toString());
        System.out.println("user:" + user.toString());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
