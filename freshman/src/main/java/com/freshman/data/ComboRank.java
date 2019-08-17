package com.freshman.data;

import java.util.Date;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/15 09:23
 * @Description:
 */
public class ComboRank {
    private String name;
    private int combo;
    private Date lastUpdateTime;

    public ComboRank(String name, int combo, Date lastUpdateTime) {
        this.name = name;
        this.combo = combo;
        this.lastUpdateTime = lastUpdateTime;
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "信息{" +
                "角色名='" + name + '\'' +
                ", 战力=" + combo +
                ", 最后更新时间=" + lastUpdateTime +
                '}';
    }




}
