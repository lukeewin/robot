package top.lukeewin.robot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Luke Ewin
 * @create 2022-10-30 18:57
 * 记录用户访问信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRecord {
    private Integer id;
    private Integer count;
    private String accessIp;
    private String accessDevice;
    private Date accessTime;
}
