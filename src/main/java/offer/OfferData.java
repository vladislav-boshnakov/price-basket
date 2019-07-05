package offer;

import java.math.BigDecimal;

public class OfferData {
    private final String message;
    private final BigDecimal amount;

    OfferData(String message, BigDecimal amount) {
        this.message = message;
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
