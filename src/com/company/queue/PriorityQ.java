package com.company.queue;

/**
 * Created by i.lapshinov on 28.05.2018.
 */
public class PriorityQ {
    int priority;
    int date;

    public PriorityQ(int priority, int date) {
        this.priority = priority;
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }
}
