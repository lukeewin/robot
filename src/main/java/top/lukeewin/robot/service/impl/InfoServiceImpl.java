package top.lukeewin.robot.service.impl;

import org.springframework.stereotype.Service;
import top.lukeewin.robot.dao.InfoDao;
import top.lukeewin.robot.entity.Info;
import top.lukeewin.robot.service.InfoService;

import javax.annotation.Resource;

/**
 * @author Luke Ewin
 * @create 2022-10-27 20:05
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Resource
    public InfoDao infoDao;

    @Override
    public void addCount(int count) {
        infoDao.addCount(count);
    }

    @Override
    public Info findCount() {
        return infoDao.findCount();
    }
}
