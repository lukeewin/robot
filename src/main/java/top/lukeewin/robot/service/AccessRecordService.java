package top.lukeewin.robot.service;

import top.lukeewin.robot.entity.AccessRecord;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Luke Ewin
 * @create 2022-10-30 19:38
 */
public interface AccessRecordService {

    void addUserAccessInfo(AccessRecord accessRecord);

    AccessRecord showAccessNumber();

    // 获取客户端真实的ip地址
    String getRealIp(HttpServletRequest request);

    // 获取客户端设备信息
    String getClientInfo(HttpServletRequest request);
}
