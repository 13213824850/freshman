package com.freshman.service;

import com.freshman.core.executor.TaskExecutor;
import com.freshman.pack.vo.Equi;
import com.freshman.pack.vo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/14 12:57
 * @Description:
 */
public abstract class AbstractEquiService<T extends Equi> {
   public static Map<Class, AbstractEquiService> equiService = new HashMap<>();
    public static final Logger logger = LoggerFactory.getLogger(AbstractEquiService.class);

    @PostConstruct
    public void init(){
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = type.getActualTypeArguments();
        equiService.put((Class) actualTypeArguments[0], this);
    }
    public abstract  boolean verify(Player player, int equiId);
    public abstract void useEqui(Player player, int equiId);
    //入包
    public abstract void addEqui(Player player, int equiId);
    public static AbstractEquiService getEquiService(Class clz){
        AbstractEquiService abstractEquiService = equiService.get(clz);
        if(abstractEquiService == null){
            logger.error("未找到装备处理器");
        }
        return abstractEquiService;
    }

}
