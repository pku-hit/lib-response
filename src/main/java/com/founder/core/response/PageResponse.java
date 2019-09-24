package com.founder.core.response;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;

/**
 * @author adam
 */
@ApiModel(value = "PageResponse", description = "通用分页返回结构")
public class PageResponse<T> extends GenericResponse<PageInfo<T>> {

    public PageResponse(ResponseCode responseCode, Object... params) {
        super(responseCode, params);
    }
}
