package top.lukeewin.robot.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Luke Ewin
 * @create 2022-10-26 23:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1147263201878313870L;

    private int code;

    private String msg;

    private T data;

    public static <T> R ok(T data) {
        return new R(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static R error() {
        return new R(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg(), null);
    }
}
