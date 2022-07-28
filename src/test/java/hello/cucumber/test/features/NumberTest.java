package hello.cucumber.test.features;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.assertj.core.api.Assertions.*;

@Scope(SCOPE_CUCUMBER_GLUE)
public class NumberTest {
    private int nowNumber = 0;
    private Boolean result;

    @Given("현재 숫자는 {int}")
    public void given(int number) {
        this.nowNumber = number;
    }

    @When("현재숫자와 10을 비교하기")
    public void when() {
        this.result = this.nowNumber == 10;
    }

    @Then("이 숫자는 10인가요? {string}")
    public void then(String result) {
        assertThat(result).isEqualTo(this.result.toString());
    }
}
