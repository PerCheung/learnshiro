package learn.quickweb.config.constant;


/**
 * 常量
 *
 * @author Peter Cheung
 * @since 2023-02-13 13:56:51
 */
public interface Constant {
    /**
     * 全局异常包路径
     */
    String PACKAGE_NAME = "learn.quickweb";

    /**
     * swagger扫描包
     */
    String SWAGGER_PACKAGE = "learn.quickweb.mvc.controller";

    /**
     * MD5盐用于混交md5
     */
    String MD5_SALT = "MD5Util";


    /**
     * jwt过期时间
     * <p>
     * 1天
     */
    long EXPIRE_TIME = 24 * 60 * 60 * 1000;
}

