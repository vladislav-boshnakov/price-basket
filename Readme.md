#Coding Test - Shopping Basket

Write a program driven by unit tests that can price a basket of goods taking into account some special
offers.

The goods that can be purchased, together with their normal prices are:

* Soup – 65p per tin
* Bread – 80p per loaf
* Milk – £1.30 per bottle
* Apples – £1.00 per bag

Current special offers:
* Apples have a 10% discount off their normal price this week
* Buy 2 tins of soup and get a loaf of bread for half price

The program should accept a list of items in the basket and output the subtotal, the special offer discounts
and the final price.

Input should be via the command line in the form 

```PriceBasket item1 item2 item3 ...```

    PriceBasket Apples Milk Bread
    
Output should be to the console, for example:
    
    Subtotal: £3.10
    Apples 10% off: ­10p
    Total: £3.00

If no special offers are applicable the code should output:
        
    Subtotal: £1.30
    (No offers available)
    Total price: £1.30
    
##Developer Notes ##
I have made the following assumptions while doing this exercise:
* All values are BigDecimals with Rounging Mode Half Up
* We display one offer per line instead of some indication of multiples

Everything was developed using TDD and refactored multiple times.

The application also runs as a jar through the command line as expected.

Run the following from terminal to get your jar

```mvn clean package``` 

Then execute ``java -jar PriceBasket.jar item1 item2 item3 ...``