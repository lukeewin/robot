package top.lukeewin.robot.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import top.lukeewin.robot.entity.Info;
import top.lukeewin.robot.service.InfoService;

import javax.annotation.Resource;

/**
 * @author Luke Ewin
 * @create 2022-10-26 19:04
 */
@Component
@Aspect
public class Statistics {

    @Resource
    private InfoService infoService;

    @Pointcut("execution(* top.lukeewin.robot.service.RobotService.getData(String))")
    public void pointCut() {

    }

    // 记录每天接口调用次数
    @After("pointCut()")
    public synchronized void count() {
        int count = 0;
        Info info = infoService.findCount(); // 先从数据库中查找出当天当前调用次数
        if (info != null) {
            count = info.getCount();
        }
        count++;
        infoService.addCount(count); // 把次数持久化到数据库中
    }
}
