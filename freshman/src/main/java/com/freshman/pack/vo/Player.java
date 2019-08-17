package com.freshman.pack.vo;

import com.freshman.scene.Scene;

import java.util.Date;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:27
 * @Description:
 */
public class Player {
    private String name;
    private String password;
    private Pack pack = new Pack();
    private Date lastDate;
   private ItemFigh itemFigh = new ItemFigh();
   private Scene scene;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }

    public ItemFigh getItemFigh() {
        return itemFigh;
    }

    public void setItemFigh(ItemFigh itemFigh) {
        this.itemFigh = itemFigh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}
