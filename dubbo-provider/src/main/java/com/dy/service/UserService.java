package com.dy.service;

import com.dy.entity.User;

/**
 * Created by dy on 2016/3/31.
 */
public interface UserService {

    public String selectUserName(String userName,Integer age);
    /**
     * 用户来时候，回调客户端方法
     * @param username
     * @param listener
     * @return
     */
    public void addUserName(String username, CallbackListener listener);

    public User registerUser(User user);
}
