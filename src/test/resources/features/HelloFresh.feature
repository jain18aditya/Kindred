Feature: Place online order
  I want to use this feature to test product shopping over a website

  @hf
  Scenario: Sign in
    Given Launch browser with url "hellofresh.url"
    When Register new user
    Then User info should be displayed correctly
    And Logout the user

	@hf
  Scenario: Log in
    Given Launch browser with url "hellofresh.url"
    When User log in with UserName "user.email" and password "password"
    Then User info should be displayed correctly
    And Logout the user

	@hf
  Scenario: Checkout
    Given Launch browser with url "hellofresh.url"
    And User log in with UserName "user.email" and password "password"
    When user navigate to "Women" section
    And select product with name "product.name"
    And Select product details and add to cart
    And Proceed to payment
    And Complete the payment details with bank wire
    Then Order should be placed successfully
    And Logout the user
    And close the browser
