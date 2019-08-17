package com.freshman.pack.vo;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 11:25
 * @Description:
 */
public class Rank {
    private int id;
    private int combo;
    private String name;
public Rank(){

}
    public Rank(int id, int combo, String name) {
        this.id = id;
        this.combo = combo;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
