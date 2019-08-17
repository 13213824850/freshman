package com.freshman.data;

import com.freshman.pack.vo.Player;
import com.freshman.util.Utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/15 09:23
 * @Description:
 */
public class RankData {
    public static Map<String,ComboRank> rankMap= new ConcurrentHashMap<>();

    public static void addRank(Player player){
           ComboRank comboRank = new ComboRank(player.getName(), player.getItemFigh().getComboSum(), new Date());
           rankMap.put(player.getName(),comboRank);
    }

    public static List<ComboRank> getRanks(){
        List<ComboRank> comboRanks = new ArrayList<>(rankMap.values());
        Collections.sort(comboRanks, new Comparator<ComboRank>() {
            @Override
            public int compare(ComboRank o1, ComboRank o2) {
                if(o1.getCombo() > o2.getCombo()){
                    return -1;
                }else if (o1.getCombo() == o2.getCombo()){
                    return o2.getLastUpdateTime().compareTo(o1.getLastUpdateTime());
                }
                return 1;
            }
        });

        return comboRanks;
    }
    /**返回前10
     */
    public static  List<ComboRank> getTopTenNum(){
        List<ComboRank> ranks = getRanks();
        List<ComboRank> topNums = new ArrayList<>();
        Utils.copy(ranks,0,topNums,10);
        return topNums;
    }

    //查看自己排名
    public static int getMyRankIndex(String name){
        List<ComboRank> ranks = getRanks();
        //二分查找提高效率
        ComboRank[] comboRanks = new ComboRank[ranks.size()];
        ranks.toArray(comboRanks);
        int index = Arrays.binarySearch(comboRanks, rankMap.get(name),new Comparator<ComboRank>() {
            @Override
            public int compare(ComboRank o1, ComboRank o2) {
                if(o1.getCombo() > o2.getCombo()){
                    return -1;
                }else if (o1.getCombo() == o2.getCombo()){
                    return o2.getLastUpdateTime().compareTo(o1.getLastUpdateTime());
                }
                return 1;
            }
        });
        return index + 1;
    }




}
