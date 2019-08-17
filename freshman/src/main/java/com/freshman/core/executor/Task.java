package com.freshman.core.executor;

public interface Task extends Runnable {

    /**
     * 用于取%的值
     * @return
     */
    long modValue();
}
