package com.founder.core.response;

import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adam
 */
@ApiModel(value = "MapResponse", description = "通用Map返回结构")
public class MapResponse<K, V> extends BaseResponse {

    protected Map<K, V> result;

    public MapResponse() {
        this.result = new HashMap<K, V>();
    }

    public MapResponse(ResponseCode input) {
        super(input);
    }

    public Map<K, V> getResult() {
        return result;
    }

    public void setResult(Map<K, V> result) {
        this.result = result;
    }

    public void put(K key, V value) {
        this.result.put(key, value);
    }


    public static <K, V> MapResponse gen(ResponseCode responseCode, Map<K, V> results) {
        MapResponse<K, V> resp = new MapResponse(responseCode);
        resp.setResult(results);
        return resp;
    }

    public static <K, V> MapResponse genSuccess(Map<K, V> result) {
        return gen(ResponseCode.Success, result);
    }

    public static <K, V> MapResponse genError(ResponseCode responseCode, String message) {
        return gen(ResponseCode.build(responseCode, message), null);
    }
}
