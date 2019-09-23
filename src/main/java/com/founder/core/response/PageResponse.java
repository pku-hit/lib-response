package com.founder.core.response;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;

/**
 * @author adam
 */
@ApiModel(value = "PageResponse", description = "通用分页返回结构")
public class PageResponse<T> extends GenericResponse<PageInfo<T>> {

    public PageResponse(ResponseCode responseCode) {
        super(responseCode);
    }

    public PageResponse(ResponseCode responseCode, PageInfo<T> results) {
        super(responseCode, results);
    }

    public static PageResponse fromResponseCode(ResponseCode responseCode) {
        return new PageResponse(responseCode);
    }
}
