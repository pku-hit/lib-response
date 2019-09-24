package com.founder.core.response;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author adam
 */
@ApiModel(value = "PageResponse", description = "通用分页返回结构")
public class PageResponse<T> extends GenericResponse<PageInfo<T>> {

    protected PageResponse(ResponseCode responseCode, Object... params) {
        super(responseCode, params);
    }


    public static <T> PageResponse genSuccess(PageInfo<T> result) {
        PageResponse<T> resp = new PageResponse<T>(ResponseCode.Success);
        resp.setResult(result);
        return resp;
    }

    public static PageResponse genError(ResponseCode responseCode, Object... params) {
        return new PageResponse(responseCode, params);
    }
}
