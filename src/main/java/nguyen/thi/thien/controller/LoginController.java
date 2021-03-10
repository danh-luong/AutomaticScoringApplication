package nguyen.thi.thien.controller;

import nguyen.thi.thien.core.jwt.JwtConfig;
import nguyen.thi.thien.core.postedobject.LoginRequest;
import nguyen.thi.thien.core.postedobject.LoginResponse;
import nguyen.thi.thien.core.userdetails.CustomedUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @GetMapping("/a")
    public String a() {
        return "hello";
    }
}
