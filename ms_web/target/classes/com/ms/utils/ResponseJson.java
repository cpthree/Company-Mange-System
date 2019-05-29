package com.ms.utils;

import java.io.Serializable;
import java.util.Map;

/**
 * 项目自定义响应架构
 * Created by acer1 on 2017/7/4.
 */
public class ResponseJson implements Serializable {
        private  String msg;
    private Long code;
    private Map<String,Object> datas;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }
}
