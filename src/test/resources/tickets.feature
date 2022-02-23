Feature: Tickets booking system

  Scenario: API reservation check
    Given airports "RIX" and "SVO"
    And seat number is 22

    And personal info is:
      | first_name | Deniss     |
      | last_name  | Tester     |
      | discount   | none       |
      | adults     | 2          |
      | kids       | 2          |
      | bags       | 2          |
      | flight     | 14-05-2018 |

    And home page opened

    When we are selecting airports
    And pressing GoGoGo button

    Then selected airports appears

    When we are filling in personal info
    And we are submitting form

    Then passenger name is show

    When we are pressing Book btn
    And selecting seat

    Then correct seat selected

    When we are making final book

    Then successful message appears

