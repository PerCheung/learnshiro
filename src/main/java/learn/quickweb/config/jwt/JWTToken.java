package learn.quickweb.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Peter Cheung
 * 2023/2/13 14:56
 */
public class JWTToken implements AuthenticationToken {
    /**
     * jwt token
     */
    private final String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
