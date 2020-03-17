package com.founder.core.response;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author adam
 */
@ApiModel(value = "ListResponse", description = "通用列表返回结构")
public class ListResponse<T> extends BaseResponse {

    protected List<T> result;

    public ListResponse() {
    }

    public ListResponse(ResponseCode input) {
        super(input);
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public static <T> ListResponse gen(ResponseCode responseCode, List<T> results) {
        ListResponse<T> resp = new ListResponse(responseCode);
        resp.setResult(results);
        return resp;
    }

    public static <T> ListResponse genSuccess(List<T> result) {
        return gen(ResponseCode.Success, result);
    }


    public static <T> ListResponse genError(ResponseCode responseCode, String message) {
        return gen(ResponseCode.build(responseCode, message), null);
    }
}
