package nguyen.thi.thien.core.jwt;

public class SecurityConstants {
    public static final String SECRET = "nguyenthiphuocthien";
    public static final long EXPIRATION_TIME = 1000 * 60 *60; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
