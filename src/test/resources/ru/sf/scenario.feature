Feature: Find restaurant

  Scenario: chose restaurant city
    Given url of restaurant  'https://dodopizza.ru/'
    Then chose city 'Краснодар'
    And assert that chosen city is 'Краснодар'
  Scenario: chose absent city
    Given url of restaurant  'https://dodopizza.ru/'
    Then chose city 'Лапландия'
    And assert that user got message 'Пиццерия в этом городе еще не открылась'




