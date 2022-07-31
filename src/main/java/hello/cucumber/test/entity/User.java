package hello.cucumber.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@AllArgsConstructor(access = lombok.AccessLevel.PUBLIC)
@NoArgsConstructor(access = lombok.AccessLevel.PUBLIC)
@Builder(access = lombok.AccessLevel.PUBLIC)
@ToString(exclude = {"no"})
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "no", nullable = false)
    private Long no;

    @NotBlank(message = "아이디는 비워둘수없습니다.")
    @Length(min = 1, max = 19, message = "아이디를 1자이상 19이하로 작성해주세요")
    private String userid;
    @NotBlank(message = "비밀번호는 비워둘수없습니다.")
    @Length(min = 1, max = 19, message = "비밀번호를 1자이상 19이하로 작성해주세요")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(no, user.no) && Objects.equals(userid, user.userid) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, userid, password);
    }

    public Long getNo() {
        return no;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }
}
