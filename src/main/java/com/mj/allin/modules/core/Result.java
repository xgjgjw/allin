package com.mj.allin.modules.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="返回值",description="调用结果信息")
public class Result<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4846480189216120373L;

    @ApiModelProperty(value="返回结果message")
    private String msg = "操作成功!";

    @ApiModelProperty(value="返回结果状态")
    private int status = 1;

    @ApiModelProperty(value="返回结果数据")
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
    private T data;

    private int draw;

    private long recordsFiltered;

    private long recordsTotal;
    public Result() {
        super();
    }

    public Result(String msg, int status, T data) {
        super();
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public Result<T> success(T object) {
        this.data = object;
        return Result.this;
    }

    public Result<T> success(T object, String msg) {
        this.msg = msg;
        this.data = object;
        return Result.this;
    }

    public Result<T> error(String msg) {
        this.msg = msg;
        this.status=0;
        return Result.this;
    }

    public Result<T> error(int code, String msg) {
        this.status = code;
        this.msg = msg;
        return Result.this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @SuppressWarnings("unchecked")
    public T getData() {
        if (data == null)
            data = (T)new Object();
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                ", data=" + data +
                ", draw=" + draw +
                ", recordsFiltered=" + recordsFiltered +
                ", recordsTotal=" + recordsTotal +
                '}';
    }
}