package top.lukeewin.robot.dao;

import org.apache.ibatis.annotations.Param;
import top.lukeewin.robot.entity.Info;

/**
 * @author Luke Ewin
 * @create 2022-10-26 19:19
 */
public interface InfoDao {

    // 添加接口调用次数
    void addCount(@Param("count") int count);

    // 查询接口调用次数
    Info findCount();
}
