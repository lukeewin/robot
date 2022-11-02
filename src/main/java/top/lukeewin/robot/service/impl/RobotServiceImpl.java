package top.lukeewin.robot.service.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.lukeewin.robot.entity.InputText;
import top.lukeewin.robot.entity.Perception;
import top.lukeewin.robot.entity.RequestData;
import top.lukeewin.robot.entity.UserInfo;
import top.lukeewin.robot.service.RobotService;

import java.util.HashMap;
import java.util.Map;

@Service
public class RobotServiceImpl implements RobotService {

    @Value("${turing.url}")
    private String url;

    @Value("${turing.apiKey}")
    private String apiKey;

    @Value("${turing.userId}")
    private String userId;

    @Value("${turing.requestType}")
    private int requestType;

    // 向图灵接口发送数据
    public String sendData(String text) {
        // 设置请求头
        Map<String, String> header = new HashMap<>();
        // 字符集必须要设置为UTF-8
        header.put("Content-Type", "application/json;charset=UTF-8");

        InputText inputText = new InputText();
        inputText.setText(text);

        Perception perception = new Perception();
        perception.setInputText(inputText);

        UserInfo userInfo = new UserInfo();
        userInfo.setApiKey(apiKey);
        userInfo.setUserId(userId);

        RequestData requestData = new RequestData();
        requestData.setReqType(requestType); // 0 表示文本类型
        requestData.setPerception(perception);
        requestData.setUserInfo(userInfo);

        Object o = JSONObject.toJSON(requestData);

        // response 为响应的内容
        String response = HttpRequest.post(url)
                .headerMap(header, false)
                .body(o.toString())
                .timeout(30 * 1000)
                .execute()
                .body();
        return response;
    }

    // 获取图灵接口返回的文本信息
    public String getData(String userText) {
        String robotResponse = sendData(userText);
        JSONObject jsonObject = JSONObject.parseObject(robotResponse);
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject obj = (JSONObject)results.get(0);
        JSONObject values = obj.getJSONObject("values");
        String text = values.getString("text");
        return text;
    }
}
