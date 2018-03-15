import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenyuepeng
 * @create 2018-03-15 14:39
 * @since: 1.0.0
 * @desc 不带参数任务
 **/
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("MyJob_" + sdf.format(new Date()));
    }
}
