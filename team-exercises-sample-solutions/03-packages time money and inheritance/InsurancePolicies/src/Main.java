import java.math.*;

public class Main {

    public static void main(String[] args) {
        HomeInsurancePolicy homeInsurancePolicy = new HomeInsurancePolicy(1,"Mr","Albert","Smith",150000,
                new BigDecimal("1206.55"),true, "15 Some Street, Anytown", 2011);
        MotorInsurancePolicy motorInsurancePolicy = new MotorInsurancePolicy(2,"Mrs","Susie","Jones",37000,
                new BigDecimal("844.19"),true, "Fiat", "Punto", 2021);
    }
}
