package com.freshman.scene;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/16 13:16
 * @Description:
 */
public abstract class Actor {
    String name;
    boolean ai;
    Scene scene;
    public Actor(String name, boolean ai){
        this.name = name;
        this.ai = ai;
        init(this);
    }
    public abstract Actor init(Actor actor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAi() {
        return ai;
    }

    public void setAi(boolean ai) {
        this.ai = ai;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
