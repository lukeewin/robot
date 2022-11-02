package top.lukeewin.robot.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.lukeewin.robot.dao.AccessRecordDao;
import top.lukeewin.robot.entity.AccessRecord;
import top.lukeewin.robot.service.AccessRecordService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Luke Ewin
 * @create 2022-10-30 19:41
 */
@Service
public class AccessRecordServiceImpl implements AccessRecordService {

    @Resource
    private AccessRecordDao accessRecordDao;

    @Override
    public void addUserAccessInfo(AccessRecord accessRecord) {
        accessRecordDao.addUserAccessInfo(accessRecord);
    }

    @Override
    public AccessRecord showAccessNumber() {
        return accessRecordDao.showAccessNumber();
    }

    @Override
    public String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    @Override
    public String getClientInfo(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        String device = null;
        //移动端访问
        if (userAgent.contains("Android") || userAgent.contains("iPhone") || userAgent.contains("iPad")){
            device = "mobileTerminal";
            request.setAttribute("device", device);
        }else {
            //PC端访问
            device = "pcTerminal";
        }
        return device;
    }
}
