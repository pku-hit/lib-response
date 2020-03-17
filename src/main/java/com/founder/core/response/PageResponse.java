package com.founder.core.response;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author adam
 */
@ApiModel(value = "PageResponse", description = "通用分页返回结构")
public class PageResponse<T> extends BaseResponse {

    protected PageInfo<T> result;

    public PageResponse() {
    }

    public PageResponse(ResponseCode input) {
        super(input);
    }

    public PageInfo<T> getResult() {
        return result;
    }

    public void setResult(PageInfo<T> result) {
        this.result = result;
    }

    public static <T> PageResponse gen(ResponseCode responseCode, PageInfo<T> results) {
        PageResponse<T> resp = new PageResponse(responseCode);
        resp.setResult(results);
        return resp;
    }

    public static <T> PageResponse genSuccess(PageInfo<T> result) {
        return gen(ResponseCode.Success, result);
    }

    public static <T> PageResponse genError(ResponseCode responseCode, String message) {
        return gen(ResponseCode.build(responseCode, message), null);
    }
}
