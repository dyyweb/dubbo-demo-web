package com.dy.service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.dy.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * Created by Administrator on 2016/3/31.
 */
@Path("users")
public interface UserService {

    @GET
    @Path("getUserName")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({ContentType.TEXT_PLAIN_UTF_8})
    public String selectUserName(@QueryParam("userName") String userName,@QueryParam("age") Integer age);
    /**
     * 用户来时候，回调客户端方法
     * @param username
     * @param listener
     * @return
     */
    @POST
    @Path("register")
    @Consumes({ContentType.APPLICATION_JSON_UTF_8})
    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    public void addUserName(String username, CallbackListener listener);
    @POST
    @Path("register")
    @Consumes({ContentType.APPLICATION_JSON_UTF_8})
    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    public User registerUser(User user);
}
