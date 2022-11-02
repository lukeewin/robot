package top.lukeewin.robot.service;

import top.lukeewin.robot.entity.Info;

/**
 * @author Luke Ewin
 * @create 2022-10-27 20:03
 */
public interface InfoService {

    void addCount(int count);

    Info findCount();
}
