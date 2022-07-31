Feature: 유저 로그인

  Background:
    Given 다음 계정들이 회원가입된다 :
      | user1 | password1 |
    Then 회원가입 확인 :
      | user1 | password1 |

  Scenario: 유저 로그인 실패 시나리오 id가 빈 공간일 경우
    When 로그인시 아이디는 비워둘수없습니다. 메세지 띄움 :
      |  | password1 |

  Scenario: 유저 로그인 실패 시나리오  password가 빈 공간일 경우
    When 로그인시 비밀번호는 비워둘수없습니다. 메세지 띄움 :
      | user1 |  |

  Scenario: 유저 로그인 실패 시나리오 비밀번호가 다를 경우
    When 비밀번호가 다를경우 IllegalArgumentException 발생 :
      | user1 | password2d |

  Scenario: 유저 로그인 실패 시나리오 아이디가 다를경우
    When  아이디가 다를경우 IllegalArgumentException 발생 :
      | user2 | password1 |

  Scenario: 유저 로그인 성공 시나리오
    When 로그인 성공 했을 경우 :
      | user1 | password1 |
