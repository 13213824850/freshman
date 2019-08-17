package com.freshman.service.equiimpl;

import com.freshman.data.Data;
import com.freshman.pack.vo.Clothe;
import com.freshman.pack.vo.Player;
import com.freshman.pack.vo.Shose;
import com.freshman.service.AbstractEquiService;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/14 18:47
 * @Description:
 */
@Component
public class ShoseService extends AbstractEquiService<Shose> {

    @Override
    public boolean verify(Player player, int equiId) {
        return player.getPack().getShoseList().get(equiId) != null;
    }

    @Override
    public void useEqui(Player player, int equiId) {
        if(!verify(player,equiId)){
            System.out.println("背包无该装备");
            return;
        }
        player.getItemFigh().setShose(player.getPack().getShoseList().get(equiId));
        System.out.println("装备成功");
    }

    @Override
    public void addEqui(Player player, int equiId) {
        player.getPack().getShoseList().put(equiId,(Shose) Data.zbs.get(equiId).clone());
    }
}
