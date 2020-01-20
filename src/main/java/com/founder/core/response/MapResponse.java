package com.founder.core.response;

import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adam
 */
@ApiModel(value = "MapResponse", description = "通用列表返回结构")
public class MapResponse<K, V> extends GenericResponse<Map<K, V>> {

    public MapResponse() {
        this.result = new HashMap<K, V>();
    }

    private MapResponse(ResponseCode responseCode, Object... params) {
        super(responseCode, params);
        this.result = new HashMap<K, V>();
    }

    public void put(K key, V value) {
        this.result.put(key, value);
    }

    public static <K, V> MapResponse genSuccess() {
        MapResponse<K, V> resp = new MapResponse<K, V>(ResponseCode.Success);
        return resp;
    }

    public static MapResponse genError(ResponseCode responseCode, Object... params) {
        return new MapResponse(responseCode, params);
    }
}
