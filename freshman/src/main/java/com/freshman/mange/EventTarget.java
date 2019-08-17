package com.freshman.mange;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/12 13:16
 * @Description:
 */
public class EventTarget {
    private Method method;
    private Object bean;

    public static EventTarget valueOf(Method method, Object bean){
        EventTarget eventTarget = new EventTarget();
        eventTarget.method = method;
        eventTarget.bean = bean;
        return eventTarget;
    }

    public void invok(Object ...args){
        try {
            method.invoke(bean,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
