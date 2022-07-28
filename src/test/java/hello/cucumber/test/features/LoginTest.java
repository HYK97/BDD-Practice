package hello.cucumber.test.features;

import hello.cucumber.test.entity.User;
import hello.cucumber.test.repository.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static hello.cucumber.test.entity.User.*;
import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.assertj.core.api.Assertions.assertThat;

@Scope(SCOPE_CUCUMBER_GLUE)
public class LoginTest extends SpringInit {
    List<User> users =new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    @Given("다음 계정들이 회원가입된다 {string} {string}")
    public void given1(String id, String password) {
        User user = User.builder().userid(id).password(password).build();
        User saveUser = userRepository.save(user);
        users.add(saveUser);
    }
    @Then("회원가입이 잘됬는지 확인 {string} {string}")
    public void then1(String id, String password) {
        for (User user : users) {
            System.out.println("user = " + user);
        }
        User findUser = userRepository.findByUserid(id);

    }

}
