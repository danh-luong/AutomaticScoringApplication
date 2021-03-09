package nguyen.thi.thien.core.repository;

import nguyen.thi.thien.core.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Users findUsersByUsername(String username);
}
