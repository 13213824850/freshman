package com.freshman.scene;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**战斗
 * @Auther: huang yuanli
 * @Description:
 */
public class Scene {
    ScheduledExecutorService scheduledExecutorService;
     int currTick;//当前时间
    List<Actor> actors;//玩家列表
    int maxTick;//存在最大时间

    //开始场景
    void startScene(){
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                tick();
                currTick++;
                if(currTick >= maxTick){
                    stop();
                }
            }

        },0, 1, TimeUnit.SECONDS);
    }

    /**
     * 没帧执行任务
     */
    protected void tick() {
        beforeTick();
        onTick();
        afterTick();
    }


    protected void beforeTick(){
        tryGameOver();
    }
    protected void onTick(){

    }

    protected void afterTick(){

    }

    protected void tryGameOver(){

    }
    //结束
    protected void stop(){
        scheduledExecutorService.shutdown();
    }
}
