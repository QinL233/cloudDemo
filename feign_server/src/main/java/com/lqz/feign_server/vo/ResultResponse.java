package com.lqz.feign_server.vo;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 09:31
 */
public class ResultResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultResponse(){
        this.code=ResponseCode.ERROR.getCode();
        this.msg=ResponseCode.ERROR.getMsg();
    }

    public ResultResponse(T data) {
        this.data = data;
        this.code=ResponseCode.SUCCESS.getCode();
        this.msg=ResponseCode.SUCCESS.getMsg();
    }

    public ResultResponse(ResponseCode rs, T data) {
        this.code = rs.getCode();
        this.msg = rs.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
