package hello.cucumber.test.features;

import hello.cucumber.test.repository.UserRepository;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;


@CucumberContextConfiguration
@SpringBootTest
public class SpringInit {
}
