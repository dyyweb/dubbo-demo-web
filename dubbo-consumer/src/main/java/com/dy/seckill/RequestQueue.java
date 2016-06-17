package com.dy.seckill;


import javax.servlet.ServletRequest;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by dy on 16-4-18.
 */
public class RequestQueue {
    public static ConcurrentLinkedQueue<ServletRequest> requestQueue = new ConcurrentLinkedQueue<>();

    public static int countRequest=0;
}
