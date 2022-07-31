package hello.cucumber.test.features;

import hello.cucumber.test.TestApplication;
import hello.cucumber.test.entity.User;
import hello.cucumber.test.repository.UserRepository;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@CucumberContextConfiguration
@SpringBootTest(classes = TestApplication.class)
public class SpringInit {


    List<User> users = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    private Validator validator;


    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void delete() {
        userRepository.deleteAll();
    }


    public void register(String id, String password) {
        User user = User.builder().userid(id).password(password).build();
        User saveUser = userRepository.save(user);
        users.add(saveUser);
    }

    public void registerTest(String id, String password) {
        User findUser = userRepository.findByUserid(id);
        assertThat(users.get(0)).isEqualTo(findUser);
    }

    public void idNotBlankTest(String id, String password) {
        User user = User.builder().userid(id).password(password).build();
        Set<ConstraintViolation<User>> validate =
                validator.validate(user);
        for (ConstraintViolation<User> userConstraintViolation : validate) {
            String message = userConstraintViolation.getMessage();
            System.out.println("message = " + message);
            assertThat(message).isEqualTo("아이디는 비워둘수없습니다.");
        }
    }

    public void passwordNotBlankTest(String id, String password) {
        User user = User.builder().userid(id).password(password).build();
        Set<ConstraintViolation<User>> validate =
                validator.validate(user);
        for (ConstraintViolation<User> userConstraintViolation : validate) {
            String message = userConstraintViolation.getMessage();
            System.out.println("message = " + message);
            assertThat(message).isEqualTo("비밀번호는 비워둘수없습니다.");
        }
    }

    public User loginTest(String id, String password) {
        return userRepository.findByUseridAndPassword(id, password).orElseThrow(() -> new IllegalArgumentException("아이디 에러"));
    }


}
