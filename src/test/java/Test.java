import com.fourfaith.QuartzMgr;
import com.fourfaith.QuartzParamsMgr;
import com.fourfaith.SchedulerMgr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyuepeng
 * @create 2018-03-15 14:40
 * @since: 1.0.0
 * @desc
 **/
public class Test {

    public static void main(String[] args) {
        SchedulerMgr.getInstance().init();
        QuartzMgr.addAfterJob(new MyJob(), 2);

        Map<String, String> map = new HashMap<String, String>();
        map.put("deviceCode", "带参数定时器");
        QuartzParamsMgr.addEvaJob(new MyJobParams(), 2, map);

        //SchedulerMgr.getInstance().addJob(new MyJob(), 10);
        //SchedulerMgr.getInstance().addAfterJob(new MyJob(), 1);
        //SchedulerMgr.getInstance().addAfterJob(new MyJob(), 1);

        // SchedulerMgr.getInstance().addAfterJob(new MyJob(), 1);

        //QuartzMgr.getInstance().addTimingJob(new MyJob(), "0 1 0/1 * * ?");
    }
}
