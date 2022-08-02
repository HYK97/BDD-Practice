Feature: 유저 로그인

  Background:
    Given 다음 계정들이 회원가입된다 "user1" "password1"
    Then 회원가입 확인 "user1" "password1"

  Scenario: 유저 로그인 실패 시나리오 id가 빈 공간일 경우
    Then  "null" "password1" "아이디는 비워둘수없습니다." 메세지를 반환

  Scenario: 유저 로그인 실패 시나리오  password가 빈 공간일 경우
    Then   "user1" "null" "비밀번호는 비워둘수없습니다." 메세지를 반환

  Scenario: 유저 로그인 실패 시나리오 비밀번호가 다를 경우
    Then 로그인 실패 "user1" "password2d"

  Scenario: 유저 로그인 실패 시나리오 아이디가 다를경우
    Then  로그인 실패 "user2" "password1"

  Scenario: 유저 로그인 성공 시나리오
    Then 로그인 성공 했을 경우 "user1" "password1"


