package hello.cucumber.test.features;

import hello.cucumber.test.entity.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class LoginTest extends SpringInit {

    @Before
    public void before() {
        setUp();
    }

    @After
    public void after() {
        delete();
    }


    @Given("다음 계정들이 회원가입된다 {string} {string}")
    public void given1(String id, String password) {
        register(id, password);
    }

    @Then("회원가입 확인 {string} {string}")
    public void then1(String id, String password) {
        registerTest(id, password);
    }


    @When("로그인시 아이디는 비워둘수없습니다. 메세지 띄움 {string}")
    public void exception1(String password) {
        idNotBlankTest(null, password);
    }

    @When("로그인시 비밀번호는 비워둘수없습니다. 메세지 띄움 {string}")
    public void exception2(String id) {
        passwordNotBlankTest(id, null);
    }

    @When("비밀번호가 다를경우 로그인 실패 {string} {string}")
    public void exception3(String id, String password) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> loginTest(id, password));
    }

    @When("아이디가 다를경우 로그인 실패 {string} {string}")
    public void exception4(String id, String password) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> loginTest(id, password));
    }

    @When("로그인 성공 했을 경우 {string} {string}")
    public void success(String id, String password) {
        User user = loginTest(id, password);
        assertThat(user.getUserid()).isEqualTo(id);
        assertThat(user.getPassword()).isEqualTo(password);
    }


}
