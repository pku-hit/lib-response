package com.founder.ihc.response;

/**
 * @author adam
 */
public class ResponseCode {
    public static final ResponseCode Success = new ResponseCode("200", "成功");
    public static final ResponseCode Error = new ResponseCode("90000", "失败");
    public static final ResponseCode ErrorDependentService = new ResponseCode("80000", "内部服务异常");

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
