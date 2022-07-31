package hello.cucumber.test.repository;

import hello.cucumber.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUseridAndPassword(String userid, String password);

    User findByUserid(String userid);
}
