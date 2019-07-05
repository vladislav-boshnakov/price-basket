package util;

import model.Basket;
import offer.DiscountApplesOffer;
import offer.Offer;
import offer.SoupAndBreadOffer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BasketUtils {

    private static List<Offer> availableOffers = new ArrayList<>(){{
        add(new DiscountApplesOffer());
        add(new SoupAndBreadOffer());
    }};

    public static String resolveAmountToString(BigDecimal amount) {
        StringBuilder sb = new StringBuilder();

        if (amount.compareTo(BigDecimal.ONE) >= 0 || amount.compareTo(BigDecimal.ZERO) == 0) {
            sb.append("£");
            amount = amount.setScale(2, RoundingMode.HALF_UP);
            sb.append(amount.toString());
        } else if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(BigDecimal.ONE) < 0) {
            amount = amount.multiply(BigDecimal.valueOf(100));
            amount = amount.setScale(0, RoundingMode.HALF_UP);
            sb.append(amount.toString());
            sb.append("p");
        }

        return sb.toString();
    }

    public static void applyExistingOffers(Basket basket) {
        basket.getOfferDataList().clear();

        for(Offer o : availableOffers){
            o.apply(basket);
        }
    }
}
