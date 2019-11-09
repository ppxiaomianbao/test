package com.concurrent.demo.common;


/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.common
 * @ClassName: ThreadHolder
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/9/1 17:03
 * @Version: 1.0
 */
public class ThreadHolder {
    private final static ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * @Method get
     * @Author limingxing
     * @Version  1.0
     * @Description todo 获取存入的数据
     * @param
     * @Return java.lang.Long
     * @Exception
     * @Date 2019/9/1 17:06
     */
    public static Long get(){
        return THREAD_LOCAL.get();
    }

    /**
     * @Method set
     * @Author limingxing
     * @Version  1.0
     * @Description todo 向threadlocal里存入数据
     * @param sessionId
     * @Return void
     * @Exception
     * @Date 2019/9/1 17:07
     */
    public static void set(long sessionId){
        THREAD_LOCAL.set(sessionId);
    }

    /**
     * @Method remove
     * @Author limingxing
     * @Version  1.0
     * @Description todo 移除threadlocal里的数据
     * @param
     * @Return void
     * @Exception
     * @Date 2019/9/1 17:07
     */
    public static void remove(){
        THREAD_LOCAL.remove();
    }

}
