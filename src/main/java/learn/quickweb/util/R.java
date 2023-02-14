package learn.quickweb.util;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回对象R
 *
 * @author Peter Cheung
 * @since 2023-02-13 13:56:51
 */
@Slf4j
@Data
@ApiModel("统一返回对象R")
public class R implements Serializable {
    private static final long serialVersionUID = -38982351468679114L;
    @ApiModelProperty(value = "响应编码")
    private int code;
    @ApiModelProperty(value = "响应信息")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private Object data;

    /**
     * 设置数据
     *
     * @param data 数据
     * @return R
     */
    public R setData(Object data) {
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
     * 认证授权失败 Unauthorized
     * 请求要求用户的身份认证
     *
     * @return R
     */
    public static R unauthorized() {
        R r = new R();
        r.code = 1401;
        r.message = "unauthorized";
        return r;
    }

    /**
     * Forbidden
     * 服务器理解请求客户端的请求，但是拒绝执行此请求
     *
     * @return R
     */
    public static R forbidden() {
        R r = new R();
        r.code = 1403;
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
        r.code = 1500;
        r.message = "Internal Server Error";
        return r;
    }
}
