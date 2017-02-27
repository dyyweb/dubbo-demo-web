package com.dy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dy.service.SeckillService;

import java.util.Date;

/**
 * Created by dy on 16-4-18.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    public String doSeckill(String name, Date time){
        System.out.println("姓名："+name+", 下单时间："+ time);
        return "success";
    }
}
