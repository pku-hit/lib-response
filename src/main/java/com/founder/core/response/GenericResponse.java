package com.founder.core.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author adam
 */
@ApiModel(value = "GenericResponse", description = "通用泛型返回值定义")
public class GenericResponse<T> extends BaseResponse {

    @ApiModelProperty(value = "返回结果", example = "Need further definition")
    protected T result;

    protected GenericResponse(ResponseCode responseCode, Object... params) {
        super(responseCode, params);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static <T> GenericResponse genSuccess(T result) {
        GenericResponse<T> resp = new GenericResponse<T>(ResponseCode.Success);
        resp.setResult(result);
        return resp;
    }

    public static GenericResponse genError(ResponseCode responseCode, Object... params) {
        return new GenericResponse(responseCode, params);
    }
}
