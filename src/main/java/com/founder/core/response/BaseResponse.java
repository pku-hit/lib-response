package com.founder.core.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

    public BaseResponse(ResponseCode responseCode) {
        this.init(responseCode);
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

    public void init(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.info = responseCode.getInfo();
    }

    public static BaseResponse fromResponseCode(ResponseCode responseCode) {
        return new BaseResponse(responseCode);
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
}
