package com.freshman.pack.vo;

import com.freshman.type.EquiType;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:34
 * @Description:武器
 */

public class Arm extends Equi{
    private int id;
    private String name;
    private int hurt;

    //战力
    private int combat;

    public void setType(EquiType type) {
        this.type = type;
    }

    public EquiType getType() {
        return type;
    }

    public Arm(){

 }
    public Arm(int id, String name, int combat, int hurt,  EquiType type) {
        this.id = id;
        this.name = name;
        this.combat = combat;
        this.hurt = hurt;
        this.type = type;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCombat() {
        return combat;
    }

    public void setCombat(int combat) {
        this.combat = combat;
    }

    @Override
    public String toString() {
        return "武器{" +
                "id=" + id +
                ", 名称='" + name + '\'' +
                ", 伤害=" + hurt +
                ", 战力=" + combat +
                ", 类型=" + type +
                '}';
    }
}
