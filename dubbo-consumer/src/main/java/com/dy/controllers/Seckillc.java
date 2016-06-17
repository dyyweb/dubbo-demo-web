package com.dy.controllers;

import com.dy.seckill.RequestQueue;
import com.dy.service.SeckillService;
import com.dy.system.SpringContextUtil;
import net.sf.serfj.RestController;
import net.sf.serfj.annotations.DoNotRenderPage;
import net.sf.serfj.annotations.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by dy on 16-4-18.
 */
public class Seckillc extends RestController {
//    @GET
//    public void seckill() {
//
//        RequestQueue.requestQueue.add(this.getResponseHelper().getRequest());
//
//        HttpServletRequest request = (HttpServletRequest) RequestQueue.requestQueue.poll();
//
//        System.out.println("sessionId:" + request.getRequestedSessionId() + "============");
//        SeckillService seckillService = (SeckillService) SpringContextUtil.getBean("seckillService");
//
////        String name = (String) this.getParam("name");
//        String name = request.getParameter("name");
//        request.setAttribute("result", seckillService.doSeckill(name, new Date()));
//        request.setAttribute("sessionId", request.getRequestedSessionId());
//        request.setAttribute("name", name);
//    }

    /**
     * 秒杀设置100件商品
     *
     * 秒杀第一步预选
     *
     * 秒杀第二步对下单用户进行资格校验,提交订单到订单队列（订单未处理）
     *
     * 秒杀第三步利用线程池(多线程)异步订单处理
     *
     * @throws Exception
     */

    @GET
    @DoNotRenderPage
    public void preselection() throws Exception {

//        RequestQueue.requestQueue.add(this.getResponseHelper().getRequest());
 RequestQueue.countRequest+=1;
        HttpServletResponse response = this.getResponseHelper().getResponse();
        response.setCharacterEncoding("utf-8");

        PrintWriter printWriter = response.getWriter();

        HttpServletRequest request = this.getResponseHelper().getRequest();

        String name = request.getParameter("name");

        if (RequestQueue.countRequest <= 100) {
//        if (RequestQueue.requestQueue.size() <= 100) {
            printWriter.write("姓名:" + name + ",预选结果:有资格");
            //记录有资格的用户,可选用redis
            //可以返回秒杀资格ticket，并自动跳转到秒杀商品页面，ticket做签名防篡改
        } else {
            printWriter.write("姓名:" + name + ",预选结果:没有资格");
            //通知没有资格的用户，你可以回家歇歇了
        }
        printWriter.flush();
        printWriter.close();

    }


    @GET
    @DoNotRenderPage
    public void seckill() throws Exception {

        RequestQueue.requestQueue.add(this.getResponseHelper().getRequest());

        HttpServletRequest request = (HttpServletRequest) RequestQueue.requestQueue.poll();

        System.out.println("sessionId:" + request.getRequestedSessionId() + "============");
        SeckillService seckillService = (SeckillService) SpringContextUtil.getBean("seckillService");

        String name = request.getParameter("name");
        String result = seckillService.doSeckill(name, new Date());


        HttpServletResponse response = this.getResponseHelper().getResponse();
//        response.setCharacterEncoding("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter printWriter = response.getWriter();
        printWriter.write("name:" + name + ",sessionId:" + request.getRequestedSessionId() + ",result:" + result);
        printWriter.flush();
        printWriter.close();
    }
}
