package com.lhf.sysfvscommon.util;

/**
 * <p>
 * 同意返回对象
 * </p>
 *
 * @author lhf
 * @since 2020/9/15 15:15
 */
public class Result<T> {

    private int code;
    private T t;
    private String message;

    public Result(int code, T t, String message) {
        this.code = code;
        this.t = t;
        this.message = message;
    }

    /**
     * 默认请求成功
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T t) {
        Status success = Status.SUCCESS;
        return new Result<>(success.code, t, success.mes);
    }

    /**
     * 自定义请求成功
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(Status status, T t, String mes) {
        return new Result<>(status.code, t, mes);
    }

    /**
     * m默认错误返回
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure() {
        return new Result<>(Status.FAILURE.code, null, Status.FAILURE.mes);
    }
    /**
     * 自定义错误返回
     *
     * @param status
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(Status status) {
        return new Result<>(status.code, null, status.mes);
    }
    /**
     * 自定义错误返回
     *
     * @param status
     * @param mes
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(Status status, String mes) {
        return new Result<>(status.code, null, mes);
    }

    /**
     * 构建
     *
     * @param <T>
     * @return
     */
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private int code;
        private T t;
        private String mes;

        public Builder<T> code(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> t(T t) {
            this.t = t;
            return this;
        }

        public Builder<T> mes(String mes) {
            this.mes = mes;
            return this;
        }

        public Result<T> build() {
            return new Result<>(this.code, this.t, this.mes);
        }
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", t=" + t +
                ", message='" + message + '\'' +
                '}';
    }
}
