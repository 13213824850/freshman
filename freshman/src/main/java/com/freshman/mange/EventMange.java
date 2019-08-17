package com.freshman.mange;

import com.freshman.annos.ReceAnno;
import com.freshman.core.executor.Task;
import com.freshman.core.executor.TaskExecutor;
import com.freshman.event.IEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/12 13:09
 * @Description:
 */
@Component
public class EventMange implements ApplicationContextAware, BeanPostProcessor {
    public static ApplicationContext ctx;
    public static Map<Class, List<EventTarget>> eventTargetMap = new HashMap<>();
    public static Map<Class, List<EventTarget>> taskEvent = new HashMap<>();
    private static int poolSize = Runtime.getRuntime().availableProcessors();
    public static TaskExecutor taskExecutors;
    private static final Logger logger = LoggerFactory.getLogger(EventMange.class);
    public static EventMange instance = new EventMange();
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public static EventMange getInstance() {
        return instance;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clz = bean.getClass();
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(ReceAnno.class) != null) {
                Parameter[] parameters = method.getParameters();
                if (method.getParameterCount() != 1) {
                    logger.error(clz + "" + method.getName() + "参数只能有一个");
                    try {
                        throw new Exception("参数只能有一个");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Class<? extends IEvent> event = (Class<? extends IEvent>) method.getParameterTypes()[0];
                if(eventTargetMap.get(event) == null){
                    eventTargetMap.put(event,new ArrayList<>());
                }
                eventTargetMap.get(event).add(EventTarget.valueOf(method, bean));
            }
        }
        return bean;
    }

    @PostConstruct
    public void init(){
        taskExecutors = new TaskExecutor("event", poolSize);
        taskExecutors.init();
    }

    public void synSubmitEvent(IEvent event){
        taskExecutors.addTask(new Task() {
            @Override
            public long modValue() {
                return event.getName().hashCode();
            }

            @Override
            public void run() {
                List<EventTarget> eventTargets = eventTargetMap.get(event.getClass());
                if(CollectionUtils.isEmpty(eventTargets)){
                    return;
                }
                for(EventTarget eventTarget : eventTargets){
                    eventTarget.invok(event);
                }
            }
        });
    }


}
