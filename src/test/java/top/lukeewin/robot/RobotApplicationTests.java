package top.lukeewin.robot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.lukeewin.robot.service.RobotService;

import javax.annotation.Resource;

@SpringBootTest
class RobotApplicationTests {

    @Resource
    private RobotService robotService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        robotService.sendData("test");
    }
}
