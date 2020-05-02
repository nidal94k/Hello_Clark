
Feature: Choose Deal

  Scenario Outline: Start Testing Page
		Given Testing page <url> is Lanuched
		Then User is at Testing Page
		Examples: 
      | url  |
      | https://www.clark.de/de/app/contracts?cv=2&utm_source=QA-engineersinterview |

  Scenario Outline: Requeste a deal
    Given user clicks Angebote
		And user clicks Privathaftpflicht
		And user accept agreement
		When user cicks requeste a quote
		And answers first question <firstAnswer>
		And answers second question <secondAsnwer>
		And answers third question <thirdAnswer>
		And sets fourth question as <fourthanswer>
		When user clicks Requte Quote
		Then Offer is ready
		Examples: 
      | firstAnswer  |secondAsnwer|thirdAnswer|fourthanswer|
      | 2 | 1|1| NA|
