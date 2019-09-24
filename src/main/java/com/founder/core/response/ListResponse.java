package com.founder.core.response;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author adam
 */
@ApiModel(value = "ListResponse", description = "通用列表返回结构")
public class ListResponse<T> extends GenericResponse<List<T>> {

    private ListResponse(ResponseCode responseCode, Object... params) {
        super(responseCode, params);
    }

    public static <T> ListResponse genSuccess(List<T> result) {
        ListResponse<T> resp = new ListResponse<T>(ResponseCode.Success);
        resp.setResult(result);
        return resp;
    }

    public static ListResponse genError(ResponseCode responseCode, Object... params) {
        return new ListResponse(responseCode, params);
    }
}
