package com.dy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dy.entity.User;
import com.dy.service.CallbackListener;
import com.dy.service.UserService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/3/31.
 */
@Service
public class UserServiceImpl implements UserService {

    public final Map<String,CallbackListener> listenerMap = new ConcurrentHashMap<String,CallbackListener>();

    public String selectUserName(String username) {
        return "哈哈我是:"+username;
    }

    /**
     * 用户来时候，回调客户端changed方法
     * 注意服务端并未提供changed方法的时候，而是客户端自己实现等等changed方法，
     * 其实就是基于长链接生成反向代理，从而使服务端调用客户端的逻辑
     * @param username
     * @param listener
     * @return
     */
    public void addUserName(String username, CallbackListener listener) {
        listenerMap.put(username, listener);
        listener.changed(username);
    }

    @Override
    public User registerUser(User user) {
        System.out.println("恭喜你注册成功userName="+user.getUserName()+",age="+user.getAge());
        return user;
    }
}
