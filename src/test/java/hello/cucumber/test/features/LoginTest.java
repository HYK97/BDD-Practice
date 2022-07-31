package hello.cucumber.test.features;

import hello.cucumber.test.entity.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

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


    @Given("다음 계정들이 회원가입된다 :")
    public void given1(DataTable data) {
        List<String> row = data.row(0);
        String id = row.get(0);
        System.out.println("id = " + id);
        String password = row.get(1);
        System.out.println("password = " + password);
        register(id, password);
    }

    @Then("회원가입 확인 :")
    public void then1(DataTable data) {
        List<String> row = data.row(0);
        String id = row.get(0);
        String password = row.get(1);
        registerTest(id, password);
    }


    @When("로그인시 아이디는 비워둘수없습니다. 메세지 띄움 :")
    public void exception1(DataTable data) {
        List<String> row = data.row(0);
        String id = row.get(0);
        String password = row.get(1);
        idNotBlankTest(id, password);
    }

    @When("로그인시 비밀번호는 비워둘수없습니다. 메세지 띄움 :")
    public void exception2(DataTable data) {
        List<String> row = data.row(0);
        String id = row.get(0);
        String password = row.get(1);
        passwordNotBlankTest(id, password);
    }

    @When("비밀번호가 다를경우 IllegalArgumentException 발생 :")
    public void exception3(DataTable data) {
        List<String> row = data.row(0);
        String id = row.get(0);
        String password = row.get(1);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> loginTest(id, password));
    }

    @When("아이디가 다를경우 IllegalArgumentException 발생 :")
    public void exception4(DataTable data) {
        List<String> row = data.row(0);
        String id = row.get(0);
        String password = row.get(1);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> loginTest(id, password));
    }

    @When("로그인 성공 했을 경우 :")
    public void success(DataTable data) {
        List<String> row = data.row(0);
        String id = row.get(0);
        String password = row.get(1);
        User user = loginTest(id, password);
        assertThat(user.getUserid()).isEqualTo(id);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}
