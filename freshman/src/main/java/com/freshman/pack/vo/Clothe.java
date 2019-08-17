package com.freshman.pack.vo;

import com.freshman.type.EquiType;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:36
 * @Description:
 */
public class Clothe extends Equi{
    private int id;
    private String name;
    private int combot;
    private int reduceHurt;

    public void setType(EquiType type) {
        this.type = type;
    }

    public EquiType getType() {
        return type;
    }

    public Clothe(){

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

    public int getCombot() {
        return combot;
    }

    public void setCombot(int combot) {
        this.combot = combot;
    }

    public void setReduceHurt(int reduceHurt) {
        this.reduceHurt = reduceHurt;
    }

    public int getReduceHurt() {
        return reduceHurt;
    }

    public Clothe(int id, String name, int combot, int reduceHurt,EquiType type) {
        this.id = id;
        this.name = name;
        this.combot = combot;
        this.reduceHurt = reduceHurt;
        this.type = type;
    }

    @Override
    public String toString() {
        return "衣服{" +
                "id=" + id +
                ", 名称='" + name + '\'' +
                ", 战力=" + combot +
                ", 减伤=" + reduceHurt +
                ", 类型=" + type.getDesc() +
                '}';
    }
}
