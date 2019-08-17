package com.freshman.pack.vo;

import com.freshman.type.EquiType;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:37
 * @Description:
 */

public class Shose extends Equi {
    private int id;
    private String name;

    private int speedMove;
    private int combo;

    public EquiType getType() {
        return type;
    }

    public void setType(EquiType type) {
        this.type = type;
    }

    public Shose(int id, String name, int combo, int speedMove, EquiType type) {
        this.id = id;
        this.name = name;
        this.combo = combo;
        this.speedMove = speedMove;
        this.type = type;

    }

    public Shose() {

    }

    public void setSpeedMove(int speedMove) {
        this.speedMove = speedMove;
    }

    public int getSpeedMove() {
        return speedMove;
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

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    @Override
    public String toString() {
        return "鞋子{" +
                "id=" + id +
                ", 名称='" + name + '\'' +
                ", 移速=" + speedMove +
                ", 战力=" + combo +
                ", 类型=" + type.getDesc() +
                '}';
    }
}
