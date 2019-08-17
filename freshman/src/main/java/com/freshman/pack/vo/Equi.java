package com.freshman.pack.vo;

import com.freshman.type.EquiType;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/14 18:45
 * @Description:
 */
public abstract class Equi implements Cloneable {
    protected EquiType type = EquiType.EMPTY;
    public abstract  EquiType getType();

    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.err.println("拷贝出错");
        return null;
    }
}
