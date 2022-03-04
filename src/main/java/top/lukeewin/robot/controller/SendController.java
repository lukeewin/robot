package top.lukeewin.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.lukeewin.robot.service.ParseDataService;

@Controller
public class SendController {

    @Autowired
    private ParseDataService parseDataService;

    @RequestMapping("/robot")
    @ResponseBody
    public String send(String userInputText) {
        String robotResponse = parseDataService.doData(userInputText);
        return robotResponse;
    }

    @RequestMapping
    public String index() {
        return "index";
    }
}
