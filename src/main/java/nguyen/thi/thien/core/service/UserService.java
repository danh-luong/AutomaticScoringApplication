package nguyen.thi.thien.core.service;

import nguyen.thi.thien.core.entity.Users;
import nguyen.thi.thien.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Users loadUserByUsernameDefault(String username) throws UsernameNotFoundException {
        Users user = userRepository.findUsersByUsername(username);
//        passwordEncoder.encode("a");
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Users accountRequest = userRepository.findUsersByUsername(username);
        if (accountRequest == null) {
            throw new UsernameNotFoundException("Not found user: " + username);
        }
        return new User(accountRequest.getUsername(), accountRequest.getPassword(), Collections.emptyList());
    }
}
