package top.lukeewin.robot.service;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lukeewin.robot.pojo.InputText;
import top.lukeewin.robot.pojo.Perception;
import top.lukeewin.robot.pojo.RequestData;
import top.lukeewin.robot.pojo.UserInfo;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendRequestService {

    // 给图灵接口发送post请求
    public String sendRequest(String text) {
        // 设置请求头
        Map<String, String> header = new HashMap<>();
        // 字符集必须要设置为UTF-8
        header.put("Content-Type", "application/json;charset=UTF-8");
        // 请求路径
        String url = "http://openapi.turingapi.com/openapi/api/v2";

        InputText inputText = new InputText();
        inputText.setText(text);

        Perception perception = new Perception();
        perception.setInputText(inputText);

        UserInfo userInfo = new UserInfo();
        userInfo.setApiKey("169e1daebd7a4138a7ec36e09af9aa43");
        userInfo.setUserId("1");

        RequestData requestData = new RequestData();
        requestData.setReqType(0); // 0 表示文本类型
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
}
