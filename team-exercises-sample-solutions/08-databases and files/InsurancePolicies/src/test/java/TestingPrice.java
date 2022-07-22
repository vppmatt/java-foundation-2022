import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.math.*;

public class TestingPrice {

    @Test
    public void testMotorPricePositiveIsOKInConstructor() throws InvalidEntryException {
        MotorInsurancePolicy motorInsurancePolicy = new MotorInsurancePolicy(123,"","",
                "",123,new BigDecimal("123"),false,"","",0);
        assertEquals(new BigDecimal("123"), motorInsurancePolicy.getPrice());
    }

    @Test
    public void testMotorPriceNegativeFailsInConstructor() {
        assertThrows(InvalidEntryException.class, () -> {
            MotorInsurancePolicy motorInsurancePolicy = new MotorInsurancePolicy(123,"","",
                    "",123,new BigDecimal("-123"),false,"","",0);

        });
    }

    @Test
    public void testMotorPricePositiveIsOKInSetMethod() throws InvalidEntryException {
        MotorInsurancePolicy motorInsurancePolicy = new MotorInsurancePolicy();
        motorInsurancePolicy.setPrice(new BigDecimal("123"));
        assertEquals(new BigDecimal("123"), motorInsurancePolicy.getPrice());
    }

    @Test
    public void testMotorPriceNegativeFailsInSetMethod() {
        MotorInsurancePolicy motorInsurancePolicy = new MotorInsurancePolicy();
        assertThrows(InvalidEntryException.class, () -> {
            motorInsurancePolicy.setPrice(new BigDecimal("-123"));
        });
    }

    @Test
    public void testHomePricePositiveIsOKInConstructor() throws InvalidEntryException {
        HomeInsurancePolicy homeInsurancePolicy = new HomeInsurancePolicy(123,"","",
                "",123,new BigDecimal("123"),false,"",0);
        assertEquals(new BigDecimal("123"), homeInsurancePolicy.getPrice());
    }

    @Test
    public void testHomePriceNegativeFailsInConstructor() {
        assertThrows(InvalidEntryException.class, () -> {
            HomeInsurancePolicy homeInsurancePolicy = new HomeInsurancePolicy(123,"","",
                    "",123,new BigDecimal("-123"),false,"",0);

        });
    }

    @Test
    public void testHomePricePositiveIsOKInSetMethod() throws InvalidEntryException {
        HomeInsurancePolicy homeInsurancePolicy = new HomeInsurancePolicy();
        homeInsurancePolicy.setPrice(new BigDecimal("123"));
        assertEquals(new BigDecimal("123"), homeInsurancePolicy.getPrice());
    }

    @Test
    public void testHomePriceNegativeFailsInSetMethod() {
        HomeInsurancePolicy homeInsurancePolicy = new HomeInsurancePolicy();
        assertThrows(InvalidEntryException.class, () -> {
            homeInsurancePolicy.setPrice(new BigDecimal("-123"));
        });
    }

}
