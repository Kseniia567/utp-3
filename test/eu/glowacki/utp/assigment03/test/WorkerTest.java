package assigment03.test;

import eu.glowacki.utp.assignment03.employee.Worker;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WorkerTest {

    private final Worker w1 = new Worker("A", "B", LocalDate.of(1922, 12,9), new BigDecimal(1000), null, LocalDate.of(2020, 1, 2), new BigDecimal(300));

    @Test
    public void isLongerYears() {
        boolean res = w1.isLongerYears(3);
        Assert.assertFalse(res);
    }

    @Test
    public void isLongerMonths() {
        boolean res = w1.isLongerMonths(3);
        Assert.assertTrue(res);
    }

    @Test
    public void bonusGreater() {
        boolean res = w1.bonusGreater(new BigDecimal(10));
        Assert.assertTrue(res);
    }
}