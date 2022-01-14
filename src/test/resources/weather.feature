Feature: Weather forecast

  Scenario: Weather for specific city
    Given city name is "Cairns"
    And country is "AU"

    When we are requesting weather data

#    Then lon is 145.77
#    And lat is -16.92

    Then coord are:
      | lon | 145.77 |
      | lat | -16.92 |

    And weather info are:
      | id          | 802              |
      | main        | Clouds           |
      | description | scattered clouds |
      | icon        | 03n              |

    And base is "stations"

    And main info is:
      | temp     | 300.15 |
      | pressure | 1007   |
      | humidity | 74     |
      | min_temp | 300.15 |
      | max_temp | 300.15 |

    And visibility are: 10000

    And wind info is:
      | speed | 3.6 |
      | deg   | 160 |

    And clouds info is:
      | all | 40 |

    And dt are: 1485790200

    And system info is:
      | type    | 1          |
      | id      | 8166       |
      | message | 0.2064     |
      | country | AU         |
      | sunrise | 1485720272 |
      | sunset  | 1485766550 |

    And id are: 2172797

    And name are: "Cairns"

    And cod are: 200
