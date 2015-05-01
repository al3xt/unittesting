package com.practicalunittesting;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by otsukanov on 27.01.2015.
 */
public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");
        assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }
}
