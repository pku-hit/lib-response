package com.founder.core.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author adam
 */
@ApiModel(value = "BaseResponse", description = "基础Body返回值定义")
public class BaseResponse {

    @ApiModelProperty(example = "RC00000")
    private String code;

    @ApiModelProperty(example = "成功")
    private String info;

    public BaseResponse() {
    }

    protected BaseResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.info = responseCode.getInfo();
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

    @JsonIgnore
    public ResponseCode getRespCode() {
        return new ResponseCode(code, info);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.getCode().equals(ResponseCode.Success.getCode());
    }

    @JsonIgnore
    public boolean isNotSuccess() {
        return !isSuccess();
    }

    @JsonIgnore
    public boolean isDependentServiceError() {
        return isError(ResponseCode.DependentServiceError);
    }

    @JsonIgnore
    public boolean isError(ResponseCode rc) {
        return this.getCode().equals(rc.getCode());
    }

    public static BaseResponse gen(ResponseCode responseCode) {
        return new BaseResponse(responseCode);
    }

    public static BaseResponse genSucc() {
        return gen(ResponseCode.Success);
    }
}
