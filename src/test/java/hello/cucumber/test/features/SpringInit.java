package hello.cucumber.test.features;

import hello.cucumber.test.TestApplication;
import hello.cucumber.test.entity.User;
import hello.cucumber.test.repository.UserRepository;
import io.cucumber.spring.CucumberContextConfiguration;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@CucumberContextConfiguration
@SpringBootTest(classes = TestApplication.class)
public class SpringInit {

    List<User> users = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    public void register(String id, String password) {
        User user = User.builder().userid(id).password(password).build();
        User saveUser = userRepository.save(user);
        users.add(saveUser);
    }

    public void registerTest(String id, String password) {
        User findUser = userRepository.findByUserid(id);
        Assertions.assertThat(users.get(0)).isEqualTo(findUser);
    }
}
