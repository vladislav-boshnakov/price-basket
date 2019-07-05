package offer;

import model.Basket;
import model.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SoupAndBreadOffer implements Offer {
    @Override
    public void apply(Basket basket) {
        if (basket.getItems().containsKey(Item.SOUP) && basket.getItems().containsKey(Item.BREAD)) {

            int timesToApplyOffer = basket.getItems().get(Item.SOUP) / 2;

            if(timesToApplyOffer > basket.getItems().get(Item.BREAD)){
                timesToApplyOffer = basket.getItems().get(Item.BREAD);
            }

            while(timesToApplyOffer > 0){
                basket.getOfferDataList().add(
                        new OfferData("Buy 2 tins of soup and get a loaf of bread for half price",
                                new BigDecimal(0.40).setScale(2, RoundingMode.HALF_UP)));

                timesToApplyOffer --;
            }
        }
    }
}
