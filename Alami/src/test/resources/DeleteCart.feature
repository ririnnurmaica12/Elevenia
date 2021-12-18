Feature: Delete product

  Scenario Outline: Search, add to cart and deleted product
    Given Access web elevenia
    When Search keyword "<product>"
    And Select category product terlaris
    And Select first product in page
    And Update "<quantity>" product
    And Direct to cart page
    And Change courier
    And Cancel change courier
    And Delete product in the cart
    Then Should be "<messageresult>" and "<result>"


    Examples:
      |product  |quantity |messageresult| result |
      |komputer |3        |Tidak ada produk di Shopping Cart.|success |