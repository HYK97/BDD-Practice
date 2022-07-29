package hello.cucumber.test.features;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class LoginTest extends SpringInit {

    @Given("다음 계정들이 회원가입된다 {string} {string}")
    public void given1(String id, String password) {
        register(id, password);
    }

    @Then("회원가입이 잘됬는지 확인 {string} {string}")
    public void then1(String id, String password) {
        registerTest(id, password);
    }

}
