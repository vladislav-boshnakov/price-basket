package model;


import offer.OfferData;
import util.BasketUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static util.BasketUtils.resolveAmountToString;

public class Basket {

    private final HashMap<Item, Integer> items = new HashMap<>();
    private List<OfferData> offerDataList;
    private BigDecimal subtotal = BigDecimal.ZERO;

    public Basket(List<Item> items) {

        for (Item i : items) {

            if (this.items.containsKey(i)) {
                this.items.replace(i, this.items.get(i) + 1);
            } else {
                this.items.put(i, 1);
            }

            this.subtotal = this.subtotal.add(i.price);
        }

        this.offerDataList = new ArrayList<>();

        BasketUtils.applyExistingOffers(this);
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public List<OfferData> getOfferDataList() {
        return offerDataList;
    }

    BigDecimal getTotal() {
        BigDecimal temp = subtotal.setScale(2, RoundingMode.HALF_UP);

        for (OfferData od : offerDataList) {
            temp = temp.subtract(od.getAmount());
        }

        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Subtotal: ").append(resolveAmountToString(subtotal)).append("\n");

        if (offerDataList.isEmpty()) {
            sb.append("(No offers available)\n");
        } else {
            offerDataList.forEach((discount) ->
                    sb.append(discount.getMessage())
                            .append(": ")
                            .append("-")
                            .append(resolveAmountToString(discount.getAmount()))
                            .append("\n"));
        }

        sb.append("Total price: ").append(resolveAmountToString(getTotal()));

        return sb.toString();
    }


}
