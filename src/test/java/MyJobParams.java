import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenyuepeng
 * @create 2018-03-15 14:39
 * @since: 1.0.0
 * @desc 带参数任务
 **/
public class MyJobParams implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        System.out.println(sdf.format(new Date()) + " ：deviceCode= " + dataMap.getString("deviceCode"));
    }
}
