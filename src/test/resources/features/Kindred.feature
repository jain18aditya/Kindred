Feature: Kindred blogs
  I want to use this feature to verify search blog functionality

  #  @smoke
  #  Scenario: Sign up
  #    Given Launch browser with url "unibet.url"
  #    And Accept cookies
  #    When Register new user
  #    Then User info should be displayed correctly
  #    And Logout the user

  @smoke
  Scenario: Log in
    Given Launch browser with url "unibet.url"
    And Accept cookies
    When User log in with UserName "user.email" and password "password"
    Then User info should be displayed correctly
    And Logout the user

  @smoke
  Scenario: Verify sidebar functionality
    Given Launch browser with url "unibet.url"
    And Accept cookies
    Then Sidebar option should be displayed correctly

  @smoke
  Scenario: Search blog using sideBar and select
    Given Launch browser with url "unibet.url"
    And Accept cookies
    And User serach blog "blog.title" using sidebar
    Then Searched blog with title "blog.title" should be displayed
    And verify browser url after search
    When User select searched blog "blog.title"
    Then Blog details should be displayed correctly

  @smoke
  Scenario: Search blog using search box and select
    Given Launch browser with url "unibet.url"
    And Accept cookies
    When open serach box using sidebar
    And User serach blog with "blog.title" by using search button
    Then Searched blog with title "blog.title" should be displayed
    And verify browser url after search
    When User select searched blog "blog.title"
    Then Blog details should be displayed correctly

  @smoke
  Scenario: Search blog and select using autosuggest options
    Given Launch browser with url "unibet.url"
    And Accept cookies
    When open serach box using sidebar
    And User serach blog with "short.title" by using autosuggest options
    Then Blog details should be displayed correctly

  @smoke
  Scenario: Clear search box and empty search
    Given Launch browser with url "unibet.url"
    And Accept cookies
    When open serach box using sidebar
    And clear search box using cross button and search
    Then verify search result

  @smoke
  Scenario: Search with invalid entry
    Given Launch browser with url "unibet.url"
    When open serach box using sidebar
    And User serach blog with "invalid.entry" by using search button
    Then verify search result

  @smoke
  Scenario: Search with unicode and special characters
    Given Launch browser with url "unibet.url"
    When open serach box using sidebar
    And User serach blog with "unicode.characters" by using search button
    Then verify search result
    And close the browser
