package top.lukeewin.robot.commons;

/**
 * @author Luke Ewin
 * @create 2022-10-26 23:50
 */
public enum ResultEnum {

    SUCCESS(200, "请求成功"),
    ERROR(500, "服务器内部错误");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
