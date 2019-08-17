package com.freshman.data;

import com.freshman.pack.vo.*;
import com.freshman.service.PlayerService;
import com.freshman.type.EquiType;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:40
 * @Description:
 */
@Component
public class Data implements ApplicationListener {

    //装备
    public static Map<Integer, Equi> zbs = new HashMap<>();
    public static TreeMap<Integer, Player> rank = new TreeMap<>();

    public static Map<String, Player> players = new ConcurrentHashMap<>();
    public void init(){
        initZB();
        //初始化吧Ai
        initAI();
    }

    private void initAI() {
        String[] strings = new String[]{
                "哈哈哈哈","我们都一样","梦无恒","战三","萌新",
        };
        Random random = new Random();
        PlayerService playerService = new PlayerService();
        for(int i = 0; i <strings.length; i++){
            //取出1-7件装备
            int count = random.nextInt(6) + 1;
            playerService.init(strings[i],count);
        }
    }

    private void initZB() {
        zbs.put(1,new Arm(1,"王者之剑",100,20 , EquiType.ARM));
        zbs.put(2,new Arm(2,"归来之剑",200,10,EquiType.ARM ));
        zbs.put(3,new Arm(3,"大宝剑",500,50 ,EquiType.ARM));

        zbs.put(4,new Clothe(4,"王冠",90,30,EquiType.CLOTHE));
        zbs.put(5,new Clothe(5,"简陋上衣",50,10,EquiType.CLOTHE));
        zbs.put(6,new Clothe(6,"稀有上衣",20,20,EquiType.CLOTHE));

        zbs.put(7,new Shose(7,"粗糙鞋子",10,10,EquiType.SHOSE));
        zbs.put(8,new Shose(8,"稀有鞋子",20,20,EquiType.SHOSE));
        zbs.put(9,new Shose(9,"闪闪发光鞋子",40,30,EquiType.SHOSE));

    }


    public static Map<String, Player> getPlayers() {
        return players;
    }
    public static void add(Player player){
        if(player == null){
            return;
        }
        players.put(player.getName(),player);

    }
    public static Player getPlayer(String userName){
        return players.get(userName);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        init();
    }
}
