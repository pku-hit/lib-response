package com.founder.ihc.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author adam
 */
@ApiModel(value = "GenericResponse", description = "通用泛型返回值定义")
public class GenericResponse<T> extends BaseResponse {

    @ApiModelProperty(value = "返回结果", example = "Need further definition")
    protected T result;

    public GenericResponse() {
    }

    public GenericResponse(ResponseCode responseCode) {
        super(responseCode);
    }

    public GenericResponse(ResponseCode responseCode, T result) {
        this(responseCode);
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
