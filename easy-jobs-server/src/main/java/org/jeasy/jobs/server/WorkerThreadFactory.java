package org.jeasy.jobs.server;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class WorkerThreadFactory implements ThreadFactory {

    private final AtomicLong count = new AtomicLong(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("worker-thread-" + count.incrementAndGet());
        return thread;
    }
}