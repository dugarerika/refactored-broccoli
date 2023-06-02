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
      | Brand |
      | Laroche |
    And Click on CREATE button
    Then the new brand is added successfully
    And Close

  Scenario: Verify delete icon works properly
    When the user clicks on the inventory icon
    And the user clicks on the delete icon button
    Then the delete product modal is displayed
    And Close

  Scenario: Verify product is delete after confirm the delete
    When the user clicks on the inventory icon
    And the user clicks on the delete icon button
    Then the delete product modal is displayed
    And Close

  Scenario: Verify product is NOT deleted after canceling the delete
    When the user clicks on the inventory icon
    And the user clicks on the delete icon button
    Then the delete product modal is displayed
    And click on CANCEL
    Then The product is delete successfully
    And Close

  Scenario: Verify product is deleted after confirming the delete
    When the user clicks on the inventory icon
    And the user clicks on the delete icon button
    Then the delete product modal is displayed
    And click on DELETE
    Then The product is delete successfully
    And Close

  Scenario Outline: Verify required fields on Add Brand form and the expected message
    When the user clicks on the inventory icon
    And the user clicks on the ADD PRODUCT button
    And the user enters <ProductName> and <ProductBrand> and <ProductCategory> and <ProductQuantity> and <ProductSKU> and <Price>
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
    And the user enters <ProductName> and <ProductBrand> and <ProductCategory> and <ProductQuantity> and <ProductSKU> and <Price>
    And click on the Submit button
    Then The <ExpectedMessage> is displayed
    And Close
    Examples:
      | ProductName         | ProductSKU | ProductQuantity | Price | ProductBrand | ProductCategory | ExpectedMessage      |
      | Deva Curls          | Dev@       | 10              | 30.4  | Inecto       | Uncategorized   | Created successfully |
      | Coconut Conditioner | 1234       | 2               | 20.5  | Inecto       | Uncategorized   | Created successfully |
      | Coconut Hair Mask   | 1234       | 20              | 6.5   | Inecto       | Uncategorized   | Created successfully |

  Scenario Outline: Verify non required field Cost Price on Add Brand form and the expected message
    When the user clicks on the inventory icon
    And the user clicks on the ADD PRODUCT button
    And the user enters <ProductName> and <ProductBrand> and <ProductCategory> and <ProductQuantity> and <ProductSKU> and <Price>
    And the <CostPrice> Cost Price
    And click on the Submit button
    Then The <ExpectedMessage> is displayed
    And Close
    Examples:
      | ProductName | ProductSKU | ProductQuantity | Price | ProductBrand | ProductCategory | CostPrice | ExpectedMessage      |
      | kerastase   | KERA       | 6               | 10.4  | &&&&&&       | Uncategorized   | e         | Created successfully |
      | Bioderma aqu| VITX       | 1               | 99.5  | &&&&&&       | Uncategorized   | 4.5       | Created successfully |
      | Vitamina C  | BIO        | 100             | 3.5   | 999999       | Uncategorized   | 10        | Created successfully |

  Scenario Outline: Verify non required Supplier Phone on Add Brand form and the expected message
    When the user clicks on the inventory icon
    And the user clicks on the ADD PRODUCT button
    And the user enters <ProductName> and <ProductBrand> and <ProductCategory> and <ProductQuantity> and <ProductSKU> and <Price>
    And the <SupplierPhone> Supplier Phone
    And click on the Submit button
    Then The <ExpectedMessage> is displayed
    And Close
    Examples:
      | ProductName | ProductSKU | ProductQuantity | Price | ProductBrand | ProductCategory | SupplierPhone | ExpectedMessage      |
      | kerastase   | KERA       | 6               | 10.4  | &&&&&&       | Uncategorized   | 38717494      | Created successfully |
      | Bioderma aqu| VITX       | 1               | 99.5  | &&&&&&       | Uncategorized   | 4.5           | Mobile number not valid |
      | Vitamina C  | BIO        | 100             | 3.5   | 999999       | Uncategorized   | 1034567       | Mobile number not valid |