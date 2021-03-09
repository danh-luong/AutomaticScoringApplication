package nguyen.thi.thien.core.jwt;

import io.jsonwebtoken.*;
import nguyen.thi.thien.core.userdetails.CustomedUserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtConfig {

    private final String JWT_SECRET = "nguyenthiphuocthien";

    private final long JWT_EXPIRATION = 1000 * 60 * 60;

    public String generateToken(CustomedUserDetails customedUserDetails) {
        Date now = new Date();
        Date expirationDate = new Date(now.getDate() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(customedUserDetails.getUser().getUsername())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            ex.printStackTrace();
        } catch (ExpiredJwtException ex) {
            ex.printStackTrace();
        } catch (UnsupportedJwtException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
