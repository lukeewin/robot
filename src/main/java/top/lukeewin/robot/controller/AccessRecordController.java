package top.lukeewin.robot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lukeewin.robot.commons.R;
import top.lukeewin.robot.entity.AccessRecord;
import top.lukeewin.robot.service.AccessRecordService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Luke Ewin
 * @create 2022-10-30 19:48
 */
@RestController
@Slf4j
public class AccessRecordController {

    @Resource
    private AccessRecordService accessRecordService;

    @GetMapping("/visitorNumber")
    public R visitorNumber(HttpServletRequest request) {
        String realIp = accessRecordService.getRealIp(request);
        String clientInfo = accessRecordService.getClientInfo(request);
        int count = 0;
        synchronized (AccessRecordController.class) {
            AccessRecord accessRecord = accessRecordService.showAccessNumber();
            if (accessRecord != null) {
                count = accessRecord.getCount();
            }
            accessRecordService.addUserAccessInfo(new AccessRecord(null, ++count, realIp, clientInfo, null));
        }
        return R.ok(count);
    }
}
