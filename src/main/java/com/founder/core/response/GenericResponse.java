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

    public GenericResponse() {
    }

    public GenericResponse(ResponseCode input) {
        super(input);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static <T> GenericResponse gen(ResponseCode responseCode, T result) {
        GenericResponse<T> resp = new GenericResponse(responseCode);
        resp.setResult(result);
        return resp;
    }

    public static <T> GenericResponse genSuccess(T result) {
        return gen(ResponseCode.Success, result);
    }

    public static <T> GenericResponse genError(ResponseCode responseCode, String message) {
        return gen(ResponseCode.build(responseCode, message), null);
    }
}
