package com.freshman.event;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/12 12:41
 * @Description:
 */
public class SkillEvent implements IEvent {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
