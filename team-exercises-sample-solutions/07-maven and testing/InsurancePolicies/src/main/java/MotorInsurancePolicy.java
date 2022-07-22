import java.math.*;
import java.util.*;

public class MotorInsurancePolicy extends InsurancePolicy {

    private String make;
    private String model;
    private int yearOfRegistration;

    public MotorInsurancePolicy() {
        super(PolicyType.MOTOR);
    }

    public MotorInsurancePolicy(long policyNumber, String title, String firstName, String surname, long sumInsured, BigDecimal price, boolean active, String make, String model, int yearOfRegistration) throws InvalidEntryException {
        super(policyNumber, title, firstName, surname, sumInsured, price, active, PolicyType.MOTOR);
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

    @Override
    public String toString() {
        return "MotorInsurancePolicy{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfRegistration=" + yearOfRegistration +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MotorInsurancePolicy that = (MotorInsurancePolicy) o;
        return yearOfRegistration == that.yearOfRegistration && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), make, model, yearOfRegistration);
    }
}
