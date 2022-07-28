Feature: 이 숫자는 10입니까?

  Scenario Outline: 각 숫자를 10과 비교
    Given 현재 숫자는 <number>
    When 현재숫자와 10을 비교하기
    Then 이 숫자는 10인가요? "<result>"

      Examples:
    | number | result |
    | 10     | true   |
    | 20     | false  |
    | 30     | false  |

