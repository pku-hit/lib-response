package com.founder.core.response;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author adam
 */
@ApiModel(value = "ListResponse", description = "通用列表返回结构")
public class ListResponse<T> extends GenericResponse<List<T>> {

    public ListResponse(ResponseCode responseCode, Object... params) {
        super(responseCode, params);
    }
}
