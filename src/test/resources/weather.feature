Feature: Weather forecast

  Scenario: Weather for specific city
    Given city name is "Cairns"
    And country is "AU"

    When we are requesting weather data

#    Then lon is 145.77
#    And lat is -16.92

    Then coordinates are:
      | lon | 145.77 |
      | lat | -16.92 |
    # And.....Feature:

    And main info is:
      | temp     | 300.15 |
      | pressure | 1007   |
      | humidity | 74     |
      | min_temp | 300.15 |
      | max_temp | 300.15 |

#    And temp is 300.15
#    And pressure is 1007
#    And humidity 74
#    And min temp 300.15
#    And max temp 300.15

    # And ....