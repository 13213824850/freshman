package com.freshman.service;

import com.alibaba.fastjson.JSON;
import com.freshman.data.ComboRank;
import com.freshman.data.Data;
import com.freshman.data.RankData;
import com.freshman.event.SkillEvent;
import com.freshman.mange.EventMange;
import com.freshman.pack.vo.*;
import com.freshman.util.RandomUtil;
import org.springframework.stereotype.Service;

import javax.crypto.interfaces.PBEKey;
import java.util.*;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 10:01
 * @Description:
 */
@Service
public class PlayerService {
    public void login(String userName) {
        Player player = Data.getPlayer(userName);
        if (player == null) {
            System.out.println("开始创建用户并初始装备");
            init(userName, 6);
        }

    }

    /***
     * 初始化player
     * @param userName
     * @param num
     * @return
     */
    public Player init(String userName, int num) {
        Player player = new Player();
        player.setName(userName);
        Data.players.put(userName, player);
        //随机选取装备  入包和穿戴
        ArrayList<Object> arrayList = RandomUtil.randomList(Data.zbs.keySet().toArray(), num);
        for(Object key : arrayList){
           try{
               Equi equi = Data.zbs.get(key);
               AbstractEquiService.getEquiService(equi.getType().getaClass()).addEqui(player,(int)key);
               AbstractEquiService.getEquiService(equi.getType().getaClass()).useEqui(player,(int)key);
           }catch (Exception e){
               System.out.println(e);
           }
        }
        RankData.addRank(player);

        return player;
    }



    public int getMyRank(String userName) {
        return RankData.getMyRankIndex(userName);
    }

    public void showPack(String userName) {
        Pack pack = Data.getPlayer(userName).getPack();
        Map<String, Object> map = new HashMap<>();
        System.out.println("\n武器：");
        pack.getArmList().forEach((key,value) -> System.out.println(key+"  " + value));
        System.out.println("\n衣服" );
        pack.getClotheList().forEach((key,value) -> System.out.println(key+"  " + value));
        System.out.println("\n鞋子" );
        pack.getShoseList().forEach((key,value) -> System.out.println(key+"  " + value));
    }

    public String show(String userName) {
        Player player = Data.getPlayer(userName);
        ItemFigh itemFigh = player.getItemFigh();
        StringBuffer sb = new StringBuffer();
        sb.append("  排名：" + RankData.getMyRankIndex(userName)+"\n");
        sb.append("  当前的武器是" +  itemFigh.getArm()+"\n");
        sb.append("  当前的衣服:" +  itemFigh.getClothe()+"\n");
        sb.append("  当前的鞋子:" + itemFigh.getShose()+"\n");
        sb.append("  当前战力:" + itemFigh.getComboSum());

        return sb.toString();
    }

    public String add(int id, String userName) {
        Player player = Data.getPlayer(userName);
        Equi equi = Data.zbs.get(id);
        if (equi == null) {
            return "系统暂无该装备";
        }
        AbstractEquiService equiService = AbstractEquiService.getEquiService(equi.getClass());
        equiService.useEqui(player, id);
        return "";
    }

    public String serach(String userName, int id) {
        String str = "暂无改装备";
        Player player = Data.players.get(userName);
        if (player.getPack().getClotheList().get(id) != null) {
            return JSON.toJSONString(player.getPack().getClotheList().get(id));
        }
        if (player.getPack().getArmList().get(id) != null) {
            return JSON.toJSONString(player.getPack().getArmList().get(id));
        }
        if (player.getPack().getShoseList().get(id) != null) {
            return JSON.toJSONString(player.getPack().getShoseList().get(id) != null);
        }
        return str;
    }

    public void showRank() {
        List<ComboRank> topTenNum = RankData.getTopTenNum();
        System.out.println("排名前10玩家如下\n");
        for(int i = 0; i < topTenNum.size(); i++){
            System.out.println(i+1 + "： "+ topTenNum.get(i));
        }

    }

   /* public String update(String userName) {
    }*/
}
