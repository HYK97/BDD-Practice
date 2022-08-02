package hello.cucumber.test.features;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


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


    @Then("{string} {string} {string} 메세지를 반환")
    public void exception1(String id, String password, String expectation) {
        if (id.equals("null"))
            id = null;
        if (password.equals("null"))
            password = null;
        notBlankTest(id, password, expectation);
    }

    @Then("로그인 실패 {string} {string}")
    public void exception2(String id, String password) {
        loginFail(id, password);
    }

    @Then("로그인 성공 했을 경우 {string} {string}")
    public void success(String id, String password) {
        loginSuccess(id, password);

    }


}
