Feature: 유저 로그인

  Scenario Outline: 유저 로그인 시나리오
    Given 다음 계정들이 회원가입된다 "<id>" "<password>"

    Then 회원가입이 잘됬는지 확인 "<id>" "<password>"

#    And 로그인 로직 실행 :
#      | user  | password1 |
#      | user2 | password3 |
#    Then 로그인 상태 확인 :
#      | ok     |
#      | failed |
#
#    When 성공하면 실패하면 페이지 각각 :
#      | www.ok.com     |
#      | www.failed.com |
#    Then 페이지 확인 :
#      | www.ok.com     |
#      | www.failed.com |
#
    Examples:
      | id    | password  |
      | user  | password1 |
      | user2 | password2 |