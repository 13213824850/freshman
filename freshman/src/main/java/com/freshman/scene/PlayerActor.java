package com.freshman.scene;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/16 13:15
 * @Description:
 */
public class PlayerActor extends Actor{
    public PlayerActor(String name, boolean ai) {
        super(name, ai);
    }

    @Override
    public Actor init(Actor actor) {
        return null;
    }
}
