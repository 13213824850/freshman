package com.freshman.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/14 19:34
 * @Description:
 */
public class RandomUtil {

    /***从objs中随机num次 去重
     * @param objs
     * @param num
     * @return
     */
    public static ArrayList<Object> randomList(Object[] objs, int num){
        int size = objs.length;
        ArrayList<Object> objects = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < num; i++ ){
            int ran = random.nextInt(size);
            if(objects.contains(objs[ran])){
                continue;
            }
            objects.add(objs[i]);
        }
        return objects;
    }
}
