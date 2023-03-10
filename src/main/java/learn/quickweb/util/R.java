package learn.quickweb.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 统一返回对象R
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:22
 */
@Slf4j
@ApiModel("统一返回对象R")
public class R implements Serializable {
    private static final long serialVersionUID = -67292705723365094L;
    @ApiModelProperty(value = "响应编码")
    private int code;
    @ApiModelProperty(value = "响应信息")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private Object data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    /**
     * 私有构造方法
     */
    private R() {
    }

    /**
     * 设置数据
     *
     * @param data 数据
     * @return R
     */
    public R data(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 成功
     *
     * @return R
     */
    public static R ok() {
        R r = new R();
        r.code = 200;
        r.message = "OK";
        return r;
    }

    /**
     * 由于被认为是客户端错误
     * 错误的请求语法
     * 无效的请求消息帧或欺骗性的请求路由
     * 服务器无法或不会处理请求。
     *
     * @return R
     */
    public static R badRequest() {
        R r = new R();
        r.code = 400;
        r.message = "Bad Request";
        return r;
    }


    /**
     * 认证授权失败 Unauthorized
     * 请求要求用户的身份认证
     * 客户端必须对自身进行身份验证才能获得请求的响应
     *
     * @return R
     */
    public static R unauthorized() {
        R r = new R();
        r.code = 401;
        r.message = "unauthorized";
        return r;
    }

    /**
     * Forbidden
     * 服务器理解请求客户端的请求，但是拒绝执行此请求
     * 客户端没有访问内容的权限，也就是说，它是未经授权的，因此服务器拒绝提供请求的资源。
     * 与401Unauthorized不同，服务器知道客户端的身份。
     *
     * @return R
     */
    public static R forbidden() {
        R r = new R();
        r.code = 403;
        r.message = "Forbidden";
        return r;
    }

    /**
     * Internal Server Error
     * 服务器内部错误，无法完成请求
     *
     * @return R
     */
    public static R exp() {
        R r = new R();
        r.code = 500;
        r.message = "Internal Server Error";
        return r;
    }
}
