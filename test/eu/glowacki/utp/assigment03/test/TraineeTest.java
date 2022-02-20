package assigment03.test;

import eu.glowacki.utp.assignment03.employee.Trainee;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TraineeTest {

    Trainee t = new Trainee("A", "B", LocalDate.of(1922, 12, 9), new BigDecimal(100), null, LocalDate.of(2008, 10, 20), 143);

    @Test
    public void isShorter() {
        boolean res = t.isShorter(50);
        Assert.assertFalse(res);
    }

    @Test
    public void isLonger() {
        boolean res = t.isLonger(50);
        Assert.assertTrue(res);
    }
}