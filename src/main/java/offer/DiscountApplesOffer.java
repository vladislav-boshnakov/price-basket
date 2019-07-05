package offer;

import model.Basket;
import model.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountApplesOffer implements Offer {

    private static final BigDecimal DISCOUNT_PERCENTAGE = BigDecimal.TEN;

    @Override
    public void apply(Basket basket) {
        if (basket.getItems().containsKey(Item.APPLES)) {
            BigDecimal valueOfApples = Item.APPLES.price.multiply(BigDecimal.valueOf(basket.getItems().get(Item.APPLES)));
            BigDecimal offerAmount = valueOfApples.multiply(DISCOUNT_PERCENTAGE).divide(new BigDecimal(100), RoundingMode.HALF_UP);

            basket.getOfferDataList().add(new OfferData(String.format("Apples %.0f%% off", DISCOUNT_PERCENTAGE), offerAmount));
        }
    }
}
