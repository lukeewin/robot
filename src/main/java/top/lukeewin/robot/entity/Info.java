package top.lukeewin.robot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Luke Ewin
 * @create 2022-10-26 19:20
 * 记录图灵接口调用情况实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private Integer id;
    private Integer count;
    private Date accessTime;
}
