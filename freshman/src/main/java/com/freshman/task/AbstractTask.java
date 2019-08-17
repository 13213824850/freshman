package com.freshman.task;

import com.freshman.core.executor.Task;
import com.freshman.mange.TaskMange;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/12 12:42
 * @Description:
 */
public abstract class AbstractTask implements Task {

    public abstract  String getName();
    @Override
    public long modValue() {
        return getName().hashCode() % TaskMange.poolSize;
    }

    @Override
    public void run() {
      exector(getName());
    }

    public abstract void exector(String name);
}
