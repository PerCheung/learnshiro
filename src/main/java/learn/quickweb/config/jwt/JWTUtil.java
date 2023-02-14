package learn.quickweb.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

import static learn.quickweb.config.constant.Constant.EXPIRE_TIME;

/**
 * @author Peter Cheung
 * 2023/2/13 14:13
 */
@Slf4j
public class JWTUtil {
    /**
     * 生成token
     */
    public static String createToken(String username, String password) {
        // token过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        //jwt_token的秘钥，同时也是用户的MD5密码
        Algorithm algorithm = Algorithm.HMAC256(password);

        //生成的token附带username信息，可携带多个信息
        return JWT.create()
                //用户名
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 通过token获取用户名
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 校验token是否正确
     */
    public static boolean verify(String token, String username, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            verifier.verify(token);
            return true;
        } catch (IllegalArgumentException | JWTVerificationException e) {
            return false;
        }
    }
}
