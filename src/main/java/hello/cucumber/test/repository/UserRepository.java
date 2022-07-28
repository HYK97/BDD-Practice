package hello.cucumber.test.repository;

import hello.cucumber.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUseridAndPassword(String userid,String password);

    User findByUserid(String userid);
}
