Scenario: Adding a third fruit to the basket
Given I have a basket with an apple costing £1.00 and a banana costing £0.50
When I add an orange costing £0.75 to the basket
Then the total price at checkout should be £1.75

Scenario: Adding a third fruit with the same price as the cheapest
Given I have a basket with an apple costing £1.00 and a banana costing £0.50
When I add another banana costing £0.50 to the basket
Then the total price at checkout should be £1.50

Scenario: Adding a third fruit with a higher price
Given I have a basket with an apple costing £1.00 and a banana costing £0.50
When I add a pineapple costing £2.00 to the basket
Then the total price at checkout should be £3.00

Scenario: Adding a third fruit with a lower price
Given I have a basket with an apple costing £1.00 and a banana costing £0.50
When I add a grape costing £0.30 to the basket
Then the total price at checkout should be £1.50

Scenario: Adding a third fruit with the highest price
Given I have a basket with an apple costing £1.00 and a banana costing £0.50
When I add a mango costing £1.50 to the basket
Then the total price at checkout should be £2.50

Scenario: Adding a fourth fruit to the basket
Given I have a basket with an apple costing £1.00, a banana costing £0.50, and an orange costing £0.75
When I add a grape costing £0.30 to the basket
Then the total price at checkout should be £2.25

Scenario: Adding a third fruit when the basket is empty
Given I have an empty basket
When I add an apple costing £1.00, a banana costing £0.50, and an orange costing £0.75 to the basket
Then the total price at checkout should be £1.75

Scenario: Adding a third fruit when there is only one fruit in the basket
Given I have a basket with an apple costing £1.00
When I add a banana costing £0.50 and an orange costing £0.75 to the basket
Then the total price at checkout should be £1.75

Scenario: Adding a third fruit when there are no fruits in the basket
Given I have an empty basket
When I add an apple costing £1.00, a banana costing £0.50, and a grape costing £0.30 to the basket
Then the total price at checkout should be £1.50

Scenario: Adding a third fruit with negative price
Given I have a basket with an apple costing £1.00 and a banana costing £0.50
When I add an orange costing -£0.75 to the basket
Then the total price at checkout should be £1.50

Scenario: Adding a third fruit with zero price
Given I have a basket with an apple costing £1.00 and a banana costing £0.50
When I add an orange costing £0.00 to the basket
Then the total price at checkout should be £1.50