package com.founder.core.response;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author adam
 */
@ApiModel(value = "ListResponse", description = "通用列表返回结构")
public class ListResponse<T> extends GenericResponse<List<T>> {

    public ListResponse() {
        super();
    }

    public ListResponse(ResponseCode responseCode) {
        super(responseCode);
    }

    public ListResponse(ResponseCode responseCode, List<T> results) {
        super(responseCode, results);
    }
}
