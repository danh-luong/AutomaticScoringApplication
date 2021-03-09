package nguyen.thi.thien.core.service;

import nguyen.thi.thien.core.entity.Users;
import nguyen.thi.thien.core.repository.UserRepository;
import nguyen.thi.thien.core.userdetails.CustomedUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findUsersByUsername(username);
//        passwordEncoder.encode("a");
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomedUserDetails(user);
    }
}
