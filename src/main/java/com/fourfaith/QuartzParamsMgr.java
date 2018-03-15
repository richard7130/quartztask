package com.fourfaith;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import com.fourfaith.comm.CommonUtils;
import org.quartz.*;
import java.util.Date;
import java.util.Map;

/**
 * @author chenyuepeng
 * @create 2018-03-15 14:35
 * @since: 1.0.0
 * @desc 定时任务管理器方法-带参数
 **/
public class QuartzParamsMgr {

    /**
     * 新增延时任务- 只执行一次
     * @param job
     * @param afterSencond 延时时间（秒）
     * @throws SchedulerException
     */
    public static void addAfterJob(Job job, int afterSencond, Map<String, String> params) {
        try {
            Date startTime = DateBuilder.futureDate(afterSencond, DateBuilder.IntervalUnit.SECOND);
            String uuid = CommonUtils.getGuid();
            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(job.getClass().getName(), uuid).build();
            if(params != null) {
                for (String k : params.keySet()) {
                    jobDetail.getJobDataMap().put(k, params.get(k));
                }
            }
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getClass().getName(), uuid).startAt(startTime)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(0))
                    .build();
            //将任务及其触发器放入调度器
            SchedulerMgr.getInstance().getScheduler().scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 新增定时执行任务-马上执行
     * @param job
     * @param evaSenond 执行频率(秒)
     * @throws SchedulerException
     */
    public static void addEvaJob(Job job, int evaSenond, Map<String, String> params) {
        try {
            //创建任务
            String uuid = CommonUtils.getGuid();
            JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(job.getClass().getName(), uuid).build();
            if(params != null) {
                for (String k : params.keySet()) {
                    jobDetail.getJobDataMap().put(k, params.get(k));
                }
            }
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getClass().getName(), uuid)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(evaSenond).repeatForever())
                    .build();
            //将任务及其触发器放入调度器
            SchedulerMgr.getInstance().getScheduler().scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * 新增延时定时任务
     * @param job
     * @param afterSencond 延时时间（秒）
     * @param evaSenond 执行频率（秒）
     * @throws SchedulerException
     */
    public static void addAfterEvaJob(Job job, int afterSencond, int evaSenond, Map<String, String> params) {
        try {
            Date startTime = DateBuilder.futureDate(afterSencond, DateBuilder.IntervalUnit.SECOND);
            String uuid = CommonUtils.getGuid();
            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(job.getClass().getName(), uuid).build();
            if(params != null) {
                for (String k : params.keySet()) {
                    jobDetail.getJobDataMap().put(k, params.get(k));
                }
            }
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getClass().getName(), uuid).startAt(startTime)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(evaSenond).repeatForever())
                    .build();
            //将任务及其触发器放入调度器
            SchedulerMgr.getInstance().getScheduler().scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 新增定点开始的定时任务
     * @param job
     * @param cron 日期格式 6个字符（或者7个字符）,空格作为间隔
     * 第一个字符是秒
     * 第二个字符是分
     * 第三个字符是小时
     * 第四个字符是天（月）（0~31，但是你需要考虑你月的天数）
     * 第五个字符是月
     * 第六个字符是天（星期）
     * 第七个字符是年
     * "0 3/30 0 * * ?" 凌晨3分开始 每30分钟执行一次
     */
    public static void addTimingJob(Job job, String cron, Map<String, String> params) {
        try {
            String uuid = CommonUtils.getGuid();
            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(job.getClass().getName(), uuid).build();
            if(params != null) {
                for (String k : params.keySet()) {
                    jobDetail.getJobDataMap().put(k, params.get(k));
                }
            }
            CronTrigger trigger = newTrigger().withIdentity(job.getClass().getName(), uuid)
                    .withSchedule(cronSchedule(cron)).build();
            //将任务及其触发器放入调度器
            SchedulerMgr.getInstance().getScheduler().scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
