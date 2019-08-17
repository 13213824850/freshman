package com.freshman.service.equiimpl;

import com.freshman.data.Data;
import com.freshman.pack.vo.Arm;
import com.freshman.pack.vo.Equi;
import com.freshman.pack.vo.Player;
import com.freshman.service.AbstractEquiService;
import org.springframework.stereotype.Component;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/14 18:57
 * @Description:
 */
@Component
public class ArmService extends AbstractEquiService<Arm> {
    @Override
    public boolean verify(Player player, int equiId) {
        if(player.getPack().getArmList().get(equiId) == null){
            System.out.println("背包中没有改装备");
            return false;
        }
        return true;
    }

    @Override
    public void useEqui(Player player, int equiId) {
        if(verify(player,equiId)){
            player.getItemFigh().setArm(player.getPack().getArmList().get(equiId));
            System.out.println("装备成功");
        }
    }

    @Override
    public void addEqui(Player player, int equiId) {
        Arm arm = (Arm) Data.zbs.get(equiId);
        player.getPack().getArmList().put(equiId, (Arm) arm.clone());
    }
}
