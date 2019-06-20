package com.soyeah.model.base;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/5/16.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 * 统一返回结果的处理
 */
public class BaseResult<T> extends BaseModel  {
    /**
     * 返回给前端的状态码，返回1代表成功 其他失败
     */
    public int code = 0;
    /**
     * 返回给前端的状态信息，success 为成功 其他为失败
     */
    public String message = "success";
    /**
     * 返回给前端的数据集结果
     */
    public T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
