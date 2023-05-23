Feature: Vendor Inventory
 Background:
   Given user is on the vendor login page
     | URL |
     | https://vendor.bookr-dev.com/ |
   And the user login into the vendor with Admin credentials
     | Email | Password |
     | testsalon | testsalon1o |

  Scenario: User should be able to access to the inventory section
    When the user clicks on the inventory icon
    Then the user has access to the inventory section
    And Close

  Scenario: Verify ADD PRODUCT button works properly
    When the user clicks on the inventory icon
    And the user clicks on the ADD PRODUCT button
    Then the Add Product form is displayed
    And clicks on close form
    And Close

  Scenario: Verify ADD BRAND button works properly
    When the user clicks on the inventory icon
    And the user clicks on the ADD BRAND button
    Then the Add Brand form is displayed
    And Close

  Scenario: Verify 'ADD BRAND' '+' to create a new brand works properly
    When the user clicks on the + icon
    And type a New Brand
    And Click on CREATE button
    Then the new brand is added successfully
    And Close

  Scenario Outline: Verify required fields on Add Brand form and the expected message
    When the user clicks on the inventory icon
    And the user clicks on the ADD PRODUCT button
    And the user enters <ProductName> and <ProductBrand> and <ProductCategory> and <ProductQuantity> and <ProductSKU> and <Price> info
    And click on the Submit button
    Then The <ExpectedMessage> is displayed
    And clicks on close form
    And Close
    Examples:
    | ProductName | ProductSKU | ProductQuantity | Price | ProductBrand | ProductCategory | ExpectedMessage                |
    |             | ABC        | 2               | 12.4  | Inecto       | Uncategorized   | Please enter product name      |
    | AV          | ABC        | 2               | 12.4  | Inecto       | Uncategorized   | Product name must be at least 3 characters|
    | Coconut Oil |            | 2               | 12.4  | Inecto       | Uncategorized   | Please enter product sku       |
    | Coconut Oil | ABC        |                 | 12.4  | Inecto       | Uncategorized   | Quantity must be a number      |
    | Coconut Oil | ABC        | A               |       | Inecto       | Uncategorized   | Quantity must be a number      |
    | Coconut Oil | ABC        | 2               |       | Inecto       | Uncategorized   | Price must be a number         |
    | Coconut Oil | ABC        | 2               | .     | Inecto       | Uncategorized   | Price must be a number         |
    | Coconut Oil | ABC        | 2               | 12.4  |              | Uncategorized   | Please select product brand    |
    | Coconut Oil | ABC        | 2               | 12.4  | Inecto       |                 | Please select product category |

  Scenario Outline: Verify required fields on Add Brand form
    When the user clicks on the inventory icon
    And the user clicks on the ADD PRODUCT button
    And the user enters <ProductName> and <ProductBrand> and <ProductCategory> and <ProductQuantity> and <ProductSKU> and <Price> info
    And click on the Submit button
    Then The <ExpectedMessage> is displayed
    And Close
    Examples:
      | ProductName | ProductSKU | ProductQuantity | Price | ProductBrand | ProductCategory | ExpectedMessage                |
      | Deva Curls  | Dev@       | 10              | 30.4  | Inecto       | Uncategorized   | Created successfully           |
      | Coconut Conditioner | 1234        | 2               | 20.5  | Inecto       | Uncategorized   | Created successfully  |
      | Coconut Hair Mask | 1234        | 20               | 6.5  | Inecto       | Uncategorized   | Created successfully    |