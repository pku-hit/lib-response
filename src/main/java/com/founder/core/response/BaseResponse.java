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

    protected BaseResponse(ResponseCode responseCode, Object... params) {
        this.init(responseCode, params);
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

    public void init(ResponseCode responseCode, Object... params) {
        this.code = responseCode.getCode();
        this.info = String.format(responseCode.getInfo(), params);
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

    public static BaseResponse gen(ResponseCode responseCode, Object... params) {
        return new BaseResponse(responseCode, params);
    }
}
