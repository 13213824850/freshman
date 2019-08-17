package com.freshman.core.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    private final String name;

    private final AtomicInteger index = new AtomicInteger();

    public NamedThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new  Thread(r, name + "-" + index.incrementAndGet());
    }
}
