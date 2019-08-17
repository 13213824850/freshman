package com.freshman.mange;

import com.freshman.core.executor.Task;
import com.freshman.core.executor.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/13 18:37
 * @Description:
 */
@Component
public class TaskMange {

    public  static int poolSize = Runtime.getRuntime().availableProcessors() + 1;
    public static TaskExecutor taskExecutors;
    @PostConstruct
    public void init(){
        TaskExecutor task = new TaskExecutor("task", poolSize);
        taskExecutors = task;
    }
    public void addTask(Task task){
        taskExecutors.addTask(task);
    }
}
