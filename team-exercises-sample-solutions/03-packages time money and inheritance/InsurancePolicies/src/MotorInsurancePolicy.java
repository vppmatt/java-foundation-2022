import java.math.*;

public class MotorInsurancePolicy extends InsurancePolicy {

    private String make;
    private String model;
    private int yearOfRegistration;

    public MotorInsurancePolicy() {
        super();
    }

    public MotorInsurancePolicy(long policyNumber, String title, String firstName, String surname, long sumInsured, BigDecimal price, boolean active, String make, String model, int yearOfRegistration) {
        super(policyNumber, title, firstName, surname, sumInsured, price, active);
        this.make = make;
        this.model = model;
        this.yearOfRegistration = yearOfRegistration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(int yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }
}
