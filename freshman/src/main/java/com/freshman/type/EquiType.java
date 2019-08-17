package com.freshman.type;

import com.freshman.pack.vo.Arm;
import com.freshman.pack.vo.Clothe;
import com.freshman.pack.vo.Shose;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/14 12:38
 * @Description:
 */
public enum  EquiType {
    EMPTY(0,"空"),
    CLOTHE(1,"衣服"){
        @Override
        public Class getaClass() {
            return Clothe.class;
        }
    },
    SHOSE(2,"鞋子"){
        @Override
        public Class getaClass() {
            return Shose.class;
        }
    },
    ARM(3,"武器"){
        @Override
        public Class getaClass() {
            return Arm.class;
        }
    },
    ;
    private int type;
    private String desc;
    private Class aClass;

    EquiType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Class getaClass() {
        return aClass;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
