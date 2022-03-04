package top.lukeewin.robot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParseDataService {

    @Autowired
    private SendRequestService request;

    // 获取图灵机器人返回的文本信息
    public String doData(String userText) {
        String robotResponse = request.sendRequest(userText);
        JSONObject jsonObject = JSONObject.parseObject(robotResponse);
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject obj = (JSONObject)results.get(0);
        JSONObject values = obj.getJSONObject("values");
        String text = values.getString("text");
        return text;
    }
}
