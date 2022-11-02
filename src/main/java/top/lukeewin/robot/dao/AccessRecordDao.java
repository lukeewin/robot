package top.lukeewin.robot.dao;

import top.lukeewin.robot.entity.AccessRecord;

/**
 * @author Luke Ewin
 * @create 2022-10-30 19:04
 */
public interface AccessRecordDao {

    // 记录用户访问信息
    void addUserAccessInfo(AccessRecord accessRecord);

    // 统计累计访问人数
    AccessRecord showAccessNumber();
}
