package top.lukeewin.robot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.lukeewin.robot.commons.R;
import top.lukeewin.robot.entity.Info;
import top.lukeewin.robot.service.InfoService;
import top.lukeewin.robot.service.RobotService;

import javax.annotation.Resource;

@Controller
public class RobotController {

    @Resource
    private RobotService robotService;

    @Resource
    private InfoService infoService;

    @RequestMapping("/robot")
    @ResponseBody
    public R send(String userInputText) {
        String robotResponse = robotService.getData(userInputText);
        return R.ok(robotResponse);
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/count")
    @ResponseBody
    public R count() {
        int count = 0;
        Info info = infoService.findCount();
        if (info != null) {
            count = info.getCount();
        }
        return R.ok(count);
    }
}
