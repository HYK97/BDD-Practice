package hello.cucumber.test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor(access = lombok.AccessLevel.PUBLIC)
@NoArgsConstructor(access = lombok.AccessLevel.PUBLIC)
@Builder(access = lombok.AccessLevel.PUBLIC)
@ToString(exclude = {"no"})
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "no", nullable = false)
    private Long no;

    private String userid;

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
}
