Feature: Sign Up
  Scenario Outline: Sign up before Buying Contract
    Given user sets email as <email>
    And password as <password>
    When user clicks Jetzt registrieren
    And picks Anrede as <sex>
    And sets firstname as <fname>
    And sets lastname as <lname> 
    And picks birthday as <birthday>
    And sets StraBe as <Straﬂe>
    And sets Hausnr as <Hausnr>
    And sets PLZ as <PLZ>
    And sets ort as <ort>
    And sets Telefonnummer as <Telefonnummer>
    Then clicks Weiter
    Then signup complete

    Examples: 
      | email  | password | sex  |fname|lname|birthday|Straﬂe|Hausnr|PLZ|ort|Telefonnummer|
      | @yopmail.com | W3lcome1! | Male |Nidal|Knaneh|11.17.1999|221|2|60306 |2|015229320777 |

    