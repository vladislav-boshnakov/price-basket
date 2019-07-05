package util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BasketUtilsTest {

    @Test
    public void zeroAmount(){
        String zeroAmountString = BasketUtils.resolveAmountToString(BigDecimal.ZERO);

        Assert.assertEquals("£0.00", zeroAmountString);
    }

    @Test
    public void lessThanOnePound() {
        Assert.assertEquals("10p", BasketUtils.resolveAmountToString(BigDecimal.valueOf(0.10f)));
    }

    @Test
    public void moreThanOnePound(){
        Assert.assertEquals("£398.76", BasketUtils.resolveAmountToString(BigDecimal.valueOf(398.76f)));
    }
}
