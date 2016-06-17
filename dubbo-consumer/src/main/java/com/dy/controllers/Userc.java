package com.dy.controllers;

import com.dy.service.CallbackListener;
import com.dy.service.UserService;
import com.dy.system.SpringContextUtil;
import net.sf.serfj.RestController;
import net.sf.serfj.annotations.DoNotRenderPage;
import net.sf.serfj.annotations.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/3/31.
 */
public class Userc extends RestController {

    @GET
    @DoNotRenderPage
    public void selectUsername() throws Exception{
        UserService userService = (UserService) SpringContextUtil.getBean("userService");
        String name = userService.selectUserName("邓洋6!");
        System.out.println(name);
        HttpServletResponse response = this.getResponseHelper().getResponse();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();

        printWriter.write(name);

        printWriter.flush();
        printWriter.close();
    }
    @GET
    @DoNotRenderPage
    public void changed() throws Exception{
        UserService userService = (UserService) SpringContextUtil.getBean("userService");
        userService.addUserName("测试用户", new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println("服务端回调客户端成功!msg:"+msg);
            }
        });
    }

}
