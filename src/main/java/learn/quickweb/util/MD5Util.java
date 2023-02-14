package learn.quickweb.util;

import org.springframework.util.DigestUtils;

import static learn.quickweb.config.constant.Constant.MD5_SALT;

/**
 * @author Peter Cheung
 * 2023/2/13 14:01
 */
public class MD5Util {
    /**
     * 生成md5
     */
    public static String toMD5(String str) {
        String base = str + MD5_SALT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}