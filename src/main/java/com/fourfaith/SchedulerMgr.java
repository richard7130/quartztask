package com.fourfaith;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author chenyuepeng
 * @create 2018-03-15 14:31
 * @since: 1.0.0
 * @desc 调度管理器
 **/
public class SchedulerMgr {

    private static final SchedulerMgr m_instance = new SchedulerMgr();
    public static SchedulerMgr getInstance()
    {
        return m_instance;
    }

    private static Scheduler scheduler;

    //创建调度器
    public boolean init() {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Scheduler getScheduler() {
        return scheduler;
    }
}
