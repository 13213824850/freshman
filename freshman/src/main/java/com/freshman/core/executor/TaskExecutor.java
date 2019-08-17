package com.freshman.core.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskExecutor {

    private static final Logger logger = LoggerFactory.getLogger(TaskExecutor.class);

    private String groupName;

    private ThreadPoolExecutor[] executors;

    public TaskExecutor(String groupName, int poolSize) {
        if (poolSize < 0 || poolSize >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("poolSize=" + poolSize + " is invalid");
        }

        this.groupName = groupName;
        executors = new ThreadPoolExecutor[poolSize];
    }

    public void init() {
        int poolSize = executors.length;
        NamedThreadFactory namedThreadFactory = new NamedThreadFactory(groupName);
        for (int i = 0; i < poolSize; i++) {
            executors[i] = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(), namedThreadFactory, new ThreadPoolExecutor.DiscardPolicy());
            executors[i].prestartAllCoreThreads();
        }
    }

    public void shutdown() {
        for (ThreadPoolExecutor executor : executors) {
            try {
                if (executor != null) {
                    executor.shutdown();;
                }
            } catch (Exception e) {
                logger.error("", e);
            }
        }

        for (int i = 0; i < executors.length; i++) {
            ThreadPoolExecutor executor = executors[i];
            if (executor != null) {
                try {
                    while(! executor.awaitTermination(10L, TimeUnit.SECONDS)) {
                        BlockingQueue<Runnable> queue = executor.getQueue();
                        logger.info("{}-{} 延迟关闭，剩余任务[{}]", groupName, i + 1, queue.size());
                    }
                } catch (Exception e) {
                    logger.error("", e);
                }
            }
        }
    }

    public void addTask(Task task) {
        int modIndex = (int) (task.modValue() % executors.length);
        executors[modIndex].submit(task);
    }
}
