import java.math.*;
import java.util.*;

public class HomeInsurancePolicy extends InsurancePolicy {

    private String address;
    private int yearBuilt;

    public HomeInsurancePolicy() {
        super(PolicyType.HOME);
    }

    public HomeInsurancePolicy(long policyNumber, String title, String firstName, String surname, long sumInsured, BigDecimal price, boolean active, String address, int yearBuilt) throws InvalidEntryException {
        super(policyNumber, title, firstName, surname, sumInsured, price, active, PolicyType.MOTOR);
        this.address = address;
        this.yearBuilt = yearBuilt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HomeInsurancePolicy that = (HomeInsurancePolicy) o;
        return yearBuilt == that.yearBuilt && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, yearBuilt);
    }

    @Override
    public String toString() {
        return "HomeInsurancePolicy{" +
                "address='" + address + '\'' +
                ", yearBuilt=" + yearBuilt +
                "} " + super.toString();
    }
}
