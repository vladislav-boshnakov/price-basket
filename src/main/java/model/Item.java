package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public enum Item {

    SOUP("Soup", new BigDecimal(0.65).setScale(2, RoundingMode.HALF_UP)),
    BREAD("Bread", new BigDecimal(0.80).setScale(2, RoundingMode.HALF_UP)),
    MILK("Milk", new BigDecimal(1.30).setScale(2, RoundingMode.HALF_UP)),
    APPLES("Apples", new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));

    private static final Map<String, Item> lookupMap = new HashMap<>(){{
        put(SOUP.name, SOUP);
        put(BREAD.name, BREAD);
        put(MILK.name, MILK);
        put(APPLES.name, APPLES);

    }};

    public final String name;
    public final BigDecimal price;

    Item(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public static Item getByName(String name){
        return lookupMap.get(name);
    }
}
