package top.lukeewin.robot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestData {
    private int reqType;
    private Perception perception;
    private UserInfo userInfo;
}
