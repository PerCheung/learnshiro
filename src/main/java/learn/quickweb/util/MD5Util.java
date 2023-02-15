package learn.quickweb.util;

import org.springframework.util.DigestUtils;

/**
 * @author Peter Cheung
 * 2023/2/13 14:01
 */
public class MD5Util {
    /**
     * 生成md5
     */
    public static String toMD5(String str, String salt) {
        String base = str + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}