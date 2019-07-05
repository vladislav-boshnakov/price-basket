package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BasketTest {

    private static List<Item> testItemsNoOffer = new ArrayList<>() {{
        add(Item.MILK);
        add(Item.SOUP);
    }};

    private static List<Item> testItemsWithApplesOffer = new ArrayList<>() {{
        add(Item.APPLES);
    }};

    private static List<Item> testItemsWithSoupAndBreadOffer = new ArrayList<>() {{
        add(Item.SOUP);
        add(Item.SOUP);
        add(Item.BREAD);
    }};

    private static List<Item> testItemsWithSoupAndBreadOfferTwice = new ArrayList<>() {{
        add(Item.SOUP);
        add(Item.SOUP);
        add(Item.BREAD);
        add(Item.SOUP);
        add(Item.SOUP);
        add(Item.BREAD);
    }};

    private Basket emptyBasket;
    private Basket fullBasketNoOffers;
    private Basket fullBasketWithApplesOffer;
    private Basket fullBasketWithSoupAndBreadOffer;
    private Basket fullBasketWithSoupAndBreadOfferTwice;

    @Before
    public void setUp() {
        emptyBasket = new Basket(new ArrayList<>());
        fullBasketNoOffers = new Basket(testItemsNoOffer);
        fullBasketWithApplesOffer = new Basket(testItemsWithApplesOffer);
        fullBasketWithSoupAndBreadOffer = new Basket(testItemsWithSoupAndBreadOffer);
        fullBasketWithSoupAndBreadOfferTwice = new Basket(testItemsWithSoupAndBreadOfferTwice);
    }

    @Test
    public void getTotal_emptyBasket() {
        Assert.assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), emptyBasket.getTotal());
    }

    @Test
    public void getTotal_withItems_noOffers() {
        Assert.assertEquals(new BigDecimal(1.95f).setScale(2, RoundingMode.HALF_UP), fullBasketNoOffers.getTotal());
    }

    @Test
    public void getTotal_withItems_withApplesOffer() {
        Assert.assertEquals(new BigDecimal(0.90f).setScale(2, RoundingMode.HALF_UP), fullBasketWithApplesOffer.getTotal());
    }

    @Test
    public void getTotal_withItems_withSoupAndBreadOffer() {
        Assert.assertEquals(new BigDecimal(1.70f).setScale(2, RoundingMode.HALF_UP), fullBasketWithSoupAndBreadOffer.getTotal());
    }

    @Test
    public void getTotal_withItems_withSoupAndBreadOfferTwice() {
        Assert.assertEquals(new BigDecimal(3.40f).setScale(2, RoundingMode.HALF_UP), fullBasketWithSoupAndBreadOfferTwice.getTotal());
    }

    @Test
    public void toString_noItems() {
        Assert.assertEquals("Subtotal: £0.00\n(No offers available)\nTotal price: £0.00", emptyBasket.toString());
    }

    @Test
    public void toString_withItems_noOffers() {
        Assert.assertEquals("Subtotal: £1.95\n(No offers available)\nTotal price: £1.95", fullBasketNoOffers.toString());
    }

    @Test
    public void toString_withItems_withApplesOffer(){
        Assert.assertEquals("Subtotal: £1.00\nApples 10% off: -10p\nTotal price: 90p", fullBasketWithApplesOffer.toString());
    }

    @Test
    public void toString_withItems_withSoupAndBreadOffer(){
        Assert.assertEquals("Subtotal: £2.10\nBuy 2 tins of soup and get a loaf of bread for half price: -40p\nTotal price: £1.70", fullBasketWithSoupAndBreadOffer.toString());
    }

    @Test
    public void toString_withItems_withSoupAndBreadOfferTwice(){
        Assert.assertEquals("Subtotal: £4.20\nBuy 2 tins of soup and get a loaf of bread for half price: -40p\nBuy 2 tins of soup and get a loaf of bread for half price: -40p\nTotal price: £3.40", fullBasketWithSoupAndBreadOfferTwice.toString());
    }
}
