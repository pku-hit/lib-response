package com.founder.core.response;

/**
 * @author adam
 */
public class ResponseCode {
    public static final ResponseCode Success = new ResponseCode("RC00000", "成功");
    public static final ResponseCode ParamError = new ResponseCode("RC60000", "参数错误: %s.");
    public static final ResponseCode DependentServiceError = new ResponseCode("RC70000", "服务调用失败: %s.");
    public static final ResponseCode DBError = new ResponseCode("RC80000", "数据库操作失败: %s.");
    public static final ResponseCode SysError = new ResponseCode("RC90000", "系统内部错误: %s.");

    private String code;
    private String info;

    public ResponseCode(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
