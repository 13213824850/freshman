package com.freshman.service.equiimpl;

import com.freshman.data.Data;
import com.freshman.pack.vo.Clothe;
import com.freshman.pack.vo.Player;
import com.freshman.service.AbstractEquiService;
import org.springframework.stereotype.Component;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/14 18:53
 * @Description:
 */
@Component
public class ClotheService extends AbstractEquiService<Clothe> {
    @Override
    public boolean verify(Player player, int equiId) {
        if(player.getPack().getClotheList().get(equiId) == null){
            System.out.println("背包中没有这个装备");
            return false;
        }
        return true;
    }

    @Override
    public void useEqui(Player player, int equiId) {
        if(verify(player, equiId)){
            player.getItemFigh().setClothe(player.getPack().getClotheList().get(equiId));
            System.out.println("装备成功");
        }

    }

    @Override
    public void addEqui(Player player, int equiId) {
        player.getPack().getClotheList().put(equiId,(Clothe)Data.zbs.get(equiId).clone());

    }
}
