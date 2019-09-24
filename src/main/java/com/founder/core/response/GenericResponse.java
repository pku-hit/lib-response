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

    public GenericResponse(ResponseCode responseCode, String... params) {
        super(responseCode, params);
    }

    public GenericResponse(ResponseCode responseCode, T result, String... params) {
        this(responseCode, params);
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static void main(String[] args) {
        String[] params = new String[]{"param1", "param2"};
        GenericResponse resp = new GenericResponse<String>(ResponseCode.ParamError, "result", params);
        System.out.println(resp);
    }
}
