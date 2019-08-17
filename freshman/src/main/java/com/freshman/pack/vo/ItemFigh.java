package com.freshman.pack.vo;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:31
 * @Description:
 */
public class ItemFigh {
private Arm arm = new Arm();
private Clothe clothe = new Clothe();
private Shose shose = new Shose();
private int comboSum;

    public Arm getArm() {
        return arm;
    }

    public void setArm(Arm arm) {
        this.arm = arm;
    }

    public Clothe getClothe() {
        return clothe;
    }

    public void setClothe(Clothe clothe) {
        this.clothe = clothe;
    }

    public Shose getShose() {
        return shose;
    }

    public void setShose(Shose shose) {
        this.shose = shose;
    }

    public int getComboSum() {
        int s = arm == null ?0:arm.getCombat();
        int d = clothe == null ? 0: clothe.getCombot();
        int ss = shose == null ? 0 : shose.getCombo();
        return  s+d+ss;

    }

    public void setComboSum(int comboSum) {
        this.comboSum = comboSum;
    }


}
