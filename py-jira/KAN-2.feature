Scenario: Buy a sandwich and a drink, get a free piece of fruit
Given the customer buys a sandwich for £5.00
And the customer buys a drink for £2.00
And the customer buys a piece of fruit for £1.00
When the customer checks out
Then the final price should be £7.00

Scenario: Buy a sandwich and a bowl of soup, get a free piece of fruit
Given the customer buys a sandwich for £5.00
And the customer buys a bowl of soup for £3.00
And the customer buys a piece of fruit for £1.00
When the customer checks out
Then the final price should be £8.00

Scenario: Buy a sandwich and two drinks, get a free piece of fruit
Given the customer buys a sandwich for £5.00
And the customer buys a drink for £2.00
And the customer buys another drink for £3.00
And the customer buys a piece of fruit for £1.00
When the customer checks out
Then the final price should be £10.00

Scenario: Buy two cold drinks on a Friday, get the cheaper one for free
Given the customer buys a cold drink for £2.00
And the customer buys another cold drink for £3.00
And today is Friday
When the customer checks out
Then the final price should be £3.00

Scenario: Buy three pieces of fruit, get the third one for free
Given the customer buys a piece of fruit for £1.00
And the customer buys another piece of fruit for £1.00
And the customer buys a third piece of fruit for £1.00
When the customer checks out
Then the final price should be £2.00

Scenario: Buy a sandwich, a drink, and three pieces of fruit, get the cheapest promotion
Given the customer buys a sandwich for £5.00
And the customer buys a drink for £2.00
And the customer buys three pieces of fruit for £1.00 each
When the customer checks out
Then the final price should be £8.00

Scenario: Buy a sandwich, a bowl of soup, and three pieces of fruit, get the cheapest promotion
Given the customer buys a sandwich for £5.00
And the customer buys a bowl of soup for £3.00
And the customer buys three pieces of fruit for £1.00 each
When the customer checks out
Then the final price should be £9.00

Scenario: Buy two cold drinks and three pieces of fruit on a Friday, get the cheapest promotion
Given the customer buys a cold drink for £2.00
And the customer buys another cold drink for £3.00
And the customer buys three pieces of fruit for £1.00 each
And today is Friday
When the customer checks out
Then the final price should be £5.00

Scenario: Buy a sandwich and a drink, but no fruit
Given the customer buys a sandwich for £5.00
And the customer buys a drink for £2.00
When the customer checks out
Then the final price should be £7.00

Scenario: Buy a sandwich and a bowl of soup, but no fruit
Given the customer buys a sandwich for £5.00
And the customer buys a bowl of soup for £3.00
When the customer checks out
Then the final price should be £8.00

Scenario: Buy a sandwich and a drink, but the fruit is out of stock
Given the customer buys a sandwich for £5.00
And the customer buys a drink for £2.00
And the fruit is out of stock
When the customer checks out
Then the final price should be £7.00

Scenario: Buy a sandwich, a drink, and a piece of fruit, but it's not Friday
Given the customer buys a sandwich for £5.00
And the customer buys a drink for £2.00
And the customer buys a piece of fruit for £1.00
And today is not Friday
When the customer checks out
Then the final price should be £7.00

Scenario: Buy two cold drinks on a Monday, no promotion applies
Given the customer buys a cold drink for £2.00
And the customer buys another cold drink for £3.00
And today is Monday
When the customer checks out
Then the final price should be £5.00

Scenario: Buy three pieces of fruit, but one is out of stock
Given the customer buys a piece of fruit for £1.00
And the customer buys another piece of fruit for £1.00
And the third piece of fruit is out of stock
When the customer checks out
Then the final price should be £2.00